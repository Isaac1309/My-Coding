#include <iostream>
#include <fstream>
#include <CL\cl.h>
#include <stdlib.h>
#include <stdio.h>

using namespace std;

int main()
{

char* source =
"__kernel void suma(\n"
"__global float* outputB,\n"
"int lado,\n"
"__global float* inputA) {\n"
"int row = get_global_id(1);\n"
"int col = get_global_id(0);\n"
"float sum = 0.0f;\n"
"sum = inputA[row*lado+col] + inputA[row*lado+col];\n"
"outputB[row*lado+col] = sum;\n"
"}\n"
"__kernel void resta(\n"
"__global float* outputC,\n"
"int lado,\n"
"__global float* inputA) {\n"
"int row = get_global_id(1);\n"
"int col = get_global_id(0);\n"
"float sum = 0.0f;\n"
"sum = inputA[row*lado+col] - 10;\n"
"outputC[row*lado+col] = sum;\n"
"}\n"
;

/*    FILE *fp;
    //const char *source;
    size_t source_size;
    fp = fopen("multiplicacion.cl", "r");
    if (!fp)
    {
        fprintf(stderr, "Failed to load kernel.\n");
        exit(1);
    }
    source = (char*)malloc(1024);
    source_size = fread( source, 1, 1024, fp);
    fclose( fp );
*/

    cout<<source<<endl;

float *A=NULL; // Input array
float *B=NULL; // Output array suma
float *C=NULL; // Output array resta


const int elements=256;
const int lado=16;

// Compute the size of the data
size_t datasize=sizeof(float)*elements;
// Allocate space for input/output data
A=(float*)malloc(datasize);
B=(float*)malloc(datasize);
C=(float*)malloc(datasize);
// Initialize the input data
int i;
for(i=0; i<elements; i++) {
A[i]=i;
B[i]=-1;
C[i]=-2;
}
/*
for(i=0; i<lado; i++) {
for(int j=0; j<lado; j++) {
cout<<A[(i*lado)+j]<<" ";
}
cout<<endl;
}
*/

cl_int ciErrNum;
// Use the first platform
cl_platform_id platform;
ciErrNum = clGetPlatformIDs(1, &platform, NULL);
cout << "PLATAFORMA " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Use the first device
cl_device_id device;
ciErrNum = clGetDeviceIDs(platform,CL_DEVICE_TYPE_ALL,1,&device,NULL);
cout << "DISPOSITIVO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;

cl_context_properties cps[3] = {CL_CONTEXT_PLATFORM, (cl_context_properties)platform, 0};

// Create the context
cl_context ctx = clCreateContext(cps,1,&device,NULL,NULL,&ciErrNum);
cout << "CONTEXTO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;

// Create the command queue
cl_command_queue myqueue = clCreateCommandQueue(ctx,device,0,&ciErrNum);
cout << "COLA DE COMANDOS " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Allocate space for Matrix A on the device
cl_mem bufferA = clCreateBuffer(ctx,CL_MEM_READ_ONLY,lado*lado*sizeof(float),NULL,&ciErrNum);
cout << "BUFFER A CREADO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Copy Matrix A to the device
ciErrNum = clEnqueueWriteBuffer(myqueue,bufferA,CL_TRUE,0,lado*lado*sizeof(float),(void *)A,0,NULL,NULL);
cout << "BUFFER A COPIADO AL CONTEXTO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Allocate space for Matrix B on the device
cl_mem bufferB = clCreateBuffer(ctx,CL_MEM_WRITE_ONLY,lado*lado*sizeof(float),NULL,&ciErrNum);
cout << "BUFFER B CREADO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Copy Matrix B to the device
//ciErrNum = clEnqueueWriteBuffer(myqueue,bufferB,CL_TRUE,0,lado*lado*sizeof(float),(void *)B,0,NULL,NULL);

// Allocate space for Matrix C on the device
cl_mem bufferC = clCreateBuffer(ctx,CL_MEM_WRITE_ONLY,lado*lado*sizeof(float),NULL,&ciErrNum);
cout << "BUFFER C CREADO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Copy Matrix B to the device
//ciErrNum = clEnqueueWriteBuffer(myqueue,bufferB,CL_TRUE,0,wA*hB*sizeof(float),(void *)C,0,NULL,NULL);
cl_program myprog = clCreateProgramWithSource (ctx,1,(const char**)&source,NULL,&ciErrNum);
cout << "PROGRAMA CREADO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Compile the program. Passing NULL for the ‘device_list’
// argument targets all devices in the context
ciErrNum = clBuildProgram(myprog, 0, NULL, NULL, NULL, NULL);
cout << "PROGRAMA COMPILADO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Create the kernel
cl_kernel mykernel[2] = {NULL, NULL};
mykernel[0] = clCreateKernel(myprog,"suma",&ciErrNum);
cout << "KERNEL O CREADO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
mykernel[1] = clCreateKernel(myprog,"resta",&ciErrNum);
cout << "KERNEL 1 CREADO " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;

// Set the kernel arguments
clSetKernelArg(mykernel[0], 0, sizeof(cl_mem), (void *)&bufferB);
clSetKernelArg(mykernel[0], 1, sizeof(cl_int), (void *)&lado);
clSetKernelArg(mykernel[0], 2, sizeof(cl_mem), (void *)&bufferA);
cout << "ARGUMENTOS PASADOS A KERNEL 0 " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
clSetKernelArg(mykernel[1], 0, sizeof(cl_mem), (void *)&bufferC);
clSetKernelArg(mykernel[1], 1, sizeof(cl_int), (void *)&lado);
clSetKernelArg(mykernel[1], 2, sizeof(cl_mem), (void *)&bufferA);
cout << "ARGUMENTOS PASADOS A KERNEL 1 " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Set local and global workgroup sizes
//We assume the matrix dimensions are divisible by 16
size_t localws[2] = {16,16} ;
size_t globalws[2] = {lado, lado};
// Execute the kernel
ciErrNum = clEnqueueNDRangeKernel(myqueue,mykernel[0],2,NULL,globalws,localws,0,NULL,NULL);
cout << "RANGO DE MATRIZ DEL KERNEL 0 " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
ciErrNum = clEnqueueNDRangeKernel(myqueue,mykernel[1],2,NULL,globalws,localws,0,NULL,NULL);
cout << "RANGO DE MATRIZ DEL KERNEL 1 " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;

ciErrNum = clEnqueueTask(myqueue, mykernel[0], 0, NULL, NULL);
cout << "KERNEL 0 EN COLA " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
ciErrNum = clEnqueueTask(myqueue, mykernel[1], 0, NULL, NULL);
cout << "KERNEL 1 EN COLA " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
// Read the output data back to the host
ciErrNum = clEnqueueReadBuffer(myqueue,bufferB,CL_TRUE,0,lado*lado*sizeof(float),(void *)B,0,NULL,NULL);
cout << "LECTURA DEL BUFFER B " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;
ciErrNum = clEnqueueReadBuffer(myqueue,bufferC,CL_TRUE,0,lado*lado*sizeof(float),(void *)C,0,NULL,NULL);
cout << "LECTURA DEL BUFFER C " << ((ciErrNum==CL_SUCCESS)?"CL_SUCCESS->":"ERROR->")<< ciErrNum <<endl;

// Verify the output
int result=1;
for(i=0; i<lado; i++) {
for(int j=0; j<lado; j++) {
cout<<B[(i*lado)+j]<<" ";
}
cout<<endl;
}

for(i=0; i<lado; i++) {
for(int j=0; j<lado; j++) {
cout<<C[(i*lado)+j]<<" ";
}
cout<<endl;
}

if(result) {
printf("Output is correct\n");
} else {
printf("Output is incorrect\n");
}
// Free OpenCL resources
clReleaseKernel(mykernel[0]);cout<<"11"<<endl;
clReleaseKernel(mykernel[1]);cout<<"11"<<endl;
clReleaseProgram(myprog);cout<<"12"<<endl;
clReleaseCommandQueue(myqueue);cout<<"13"<<endl;
clReleaseMemObject(bufferA);cout<<"14"<<endl;
clReleaseMemObject(bufferB);cout<<"15"<<endl;
clReleaseMemObject(bufferC);cout<<"16"<<endl;
clReleaseContext(ctx);cout<<"17"<<endl;
// Free host resources
free(A);cout<<"18"<<endl;
free(B);cout<<"19"<<endl;
free(C);cout<<"20"<<endl;
//free(platform);cout<<"21"<<endl;
//free(device);cout<<"22"<<endl;

    return 0;
}
