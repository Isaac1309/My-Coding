#include <stdio.h>
#include <stdlib.h>
#include <CL\cl.h> // "CL/cl.h" para Linux, "CL\cl.h" para Windows

#define MAX_SOURCE_SIZE 512 // tamaño máximo del archivo con el código fuente OCL
#define VECTOR_SIZE 1024    // tamaño de los vectores


int main(){
    // Crear en inicializar los vectores de datos

    float *V1 = (float*)malloc(sizeof(float)*VECTOR_SIZE);
    float *V2 = (float*)malloc(sizeof(float)*VECTOR_SIZE);

    int i;

    for(i = 0; i < VECTOR_SIZE; i++){
        V1[i] = (float)i / 10;
        V2[i] = -(float)i / 9;
    }

    // Cargar el codigo fuente del programa y guardar en "source_str"
    FILE *fp;
    char *source_str;
    size_t source_size;

    fp = fopen("example.cl", "r");
    if (!fp){
        fprintf(stderr, "Failed to load kernel.\n");
        exit(1);
    }
    source_str = (char*)malloc(MAX_SOURCE_SIZE);
    source_size = fread( source_str, 1, MAX_SOURCE_SIZE, fp);
    fclose( fp );

    // Obtener la información de los dispositivos OCL disponibles en el sistema
    cl_platform_id platform_id = NULL;
    cl_device_id device_id = NULL;
    cl_uint ret_num_devices;
    cl_uint ret_num_platforms;

    cl_int ret = clGetPlatformIDs(1, &platform_id, &ret_num_platforms);
    ret = clGetDeviceIDs( platform_id, CL_DEVICE_TYPE_ALL, 1, &device_id, &ret_num_devices);

    // Crear el contexto de dispositivo OCL
    cl_context context = clCreateContext( NULL, 1, &device_id, NULL, NULL, &ret);

    // Crear los comandos de ejecución
    cl_command_queue command = clCreateCommandQueue(context, device_id, 0, &ret);

    // Crear los buffers de memoria en el dispositivo para guardar los datos a procesar
    cl_mem v1_mem_obj = clCreateBuffer(context, CL_MEM_READ_ONLY, VECTOR_SIZE * sizeof(float), NULL, &ret);
    cl_mem v2_mem_obj = clCreateBuffer(context, CL_MEM_READ_ONLY, VECTOR_SIZE * sizeof(float), NULL, &ret);
    cl_mem v3_mem_obj = clCreateBuffer(context, CL_MEM_WRITE_ONLY, VECTOR_SIZE * sizeof(float), NULL, &ret);

    // Copiar los vectores V1 y V2 a su respectivo buffer en el dispositivo
    ret = clEnqueueWriteBuffer(command, v1_mem_obj, CL_TRUE, 0, VECTOR_SIZE * sizeof(float), V1, 0, NULL, NULL);
    ret = clEnqueueWriteBuffer(command, v2_mem_obj, CL_TRUE, 0, VECTOR_SIZE * sizeof(float), V2, 0, NULL, NULL);

    // Crear el programa para el kernel desde el codigo fuente guardado
    cl_program program = clCreateProgramWithSource(context, 1, (const char **)&source_str, (const size_t *)&source_size, &ret);

    // Compilar el programa
    ret = clBuildProgram(program, 1, &device_id, NULL, NULL, NULL);

    // Crear el Kernel OCL
    cl_kernel kernel = clCreateKernel(program, "vector_add", &ret);

    // Crear los argumentos que se pasarán al Kernel
    ret = clSetKernelArg(kernel, 0, sizeof(cl_mem), (void *)&v1_mem_obj);
    ret = clSetKernelArg(kernel, 1, sizeof(cl_mem), (void *)&v2_mem_obj);
    ret = clSetKernelArg(kernel, 2, sizeof(cl_mem), (void *)&v3_mem_obj);

    // Ejecución del Kernel
    size_t global_item_size = VECTOR_SIZE; // Numero de workers a usar
    size_t local_item_size = 64; // Se procesaran en grupos de 64
    ret = clEnqueueNDRangeKernel(command, kernel, 1, NULL, &global_item_size, &local_item_size, 0, NULL, NULL);

    // Leer los datos del buffer v3 del dispositivo y guardarlo en la variable local V3
    float *V3 = (float*)malloc(sizeof(float)*VECTOR_SIZE);
    ret = clEnqueueReadBuffer(command, v3_mem_obj, CL_TRUE, 0,VECTOR_SIZE * sizeof(float), V3, 0, NULL, NULL);

    // Mostrar los primeros 100 resultados
    for(i = 0; i < 100; i++)
        printf("%f + %f = %f\n", V1[i], V2[i], V3[i]);

    // Liberar la memoria que se reservo
    ret = clFlush(command);
    ret = clFinish(command);
    ret = clReleaseKernel(kernel);
    ret = clReleaseProgram(program);
    ret = clReleaseMemObject(v1_mem_obj);
    ret = clReleaseMemObject(v2_mem_obj);
    ret = clReleaseMemObject(v3_mem_obj);
    ret = clReleaseCommandQueue(command);
    ret = clReleaseContext(context);
    free(V1);
    free(V2);
    free(V3);

return 0;
}
