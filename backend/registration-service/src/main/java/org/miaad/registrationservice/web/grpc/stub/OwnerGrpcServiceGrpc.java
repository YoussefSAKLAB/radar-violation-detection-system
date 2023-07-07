package org.miaad.registrationservice.web.grpc.stub;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: owner-service.proto")
public final class OwnerGrpcServiceGrpc {

  private OwnerGrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "OwnerGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<OwnerService.GetOwnerRequest,
          OwnerService.GetOwnerResponse> getGetOwnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOwner",
      requestType = OwnerService.GetOwnerRequest.class,
      responseType = OwnerService.GetOwnerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OwnerService.GetOwnerRequest,
          OwnerService.GetOwnerResponse> getGetOwnerMethod() {
    io.grpc.MethodDescriptor<OwnerService.GetOwnerRequest, OwnerService.GetOwnerResponse> getGetOwnerMethod;
    if ((getGetOwnerMethod = OwnerGrpcServiceGrpc.getGetOwnerMethod) == null) {
      synchronized (OwnerGrpcServiceGrpc.class) {
        if ((getGetOwnerMethod = OwnerGrpcServiceGrpc.getGetOwnerMethod) == null) {
          OwnerGrpcServiceGrpc.getGetOwnerMethod = getGetOwnerMethod = 
              io.grpc.MethodDescriptor.<OwnerService.GetOwnerRequest, OwnerService.GetOwnerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OwnerGrpcService", "getOwner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerService.GetOwnerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerService.GetOwnerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OwnerGrpcServiceMethodDescriptorSupplier("getOwner"))
                  .build();
          }
        }
     }
     return getGetOwnerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<OwnerService.GetAllOwnersRequest,
          OwnerService.GetAllOwnersResponse> getListOwnersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listOwners",
      requestType = OwnerService.GetAllOwnersRequest.class,
      responseType = OwnerService.GetAllOwnersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OwnerService.GetAllOwnersRequest,
          OwnerService.GetAllOwnersResponse> getListOwnersMethod() {
    io.grpc.MethodDescriptor<OwnerService.GetAllOwnersRequest, OwnerService.GetAllOwnersResponse> getListOwnersMethod;
    if ((getListOwnersMethod = OwnerGrpcServiceGrpc.getListOwnersMethod) == null) {
      synchronized (OwnerGrpcServiceGrpc.class) {
        if ((getListOwnersMethod = OwnerGrpcServiceGrpc.getListOwnersMethod) == null) {
          OwnerGrpcServiceGrpc.getListOwnersMethod = getListOwnersMethod = 
              io.grpc.MethodDescriptor.<OwnerService.GetAllOwnersRequest, OwnerService.GetAllOwnersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OwnerGrpcService", "listOwners"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerService.GetAllOwnersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerService.GetAllOwnersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OwnerGrpcServiceMethodDescriptorSupplier("listOwners"))
                  .build();
          }
        }
     }
     return getListOwnersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<OwnerService.SaveOwnerRequest,
          OwnerService.SaveOwnerResponse> getSaveOwnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveOwner",
      requestType = OwnerService.SaveOwnerRequest.class,
      responseType = OwnerService.SaveOwnerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OwnerService.SaveOwnerRequest,
          OwnerService.SaveOwnerResponse> getSaveOwnerMethod() {
    io.grpc.MethodDescriptor<OwnerService.SaveOwnerRequest, OwnerService.SaveOwnerResponse> getSaveOwnerMethod;
    if ((getSaveOwnerMethod = OwnerGrpcServiceGrpc.getSaveOwnerMethod) == null) {
      synchronized (OwnerGrpcServiceGrpc.class) {
        if ((getSaveOwnerMethod = OwnerGrpcServiceGrpc.getSaveOwnerMethod) == null) {
          OwnerGrpcServiceGrpc.getSaveOwnerMethod = getSaveOwnerMethod = 
              io.grpc.MethodDescriptor.<OwnerService.SaveOwnerRequest, OwnerService.SaveOwnerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OwnerGrpcService", "saveOwner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerService.SaveOwnerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerService.SaveOwnerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OwnerGrpcServiceMethodDescriptorSupplier("saveOwner"))
                  .build();
          }
        }
     }
     return getSaveOwnerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OwnerGrpcServiceStub newStub(io.grpc.Channel channel) {
    return new OwnerGrpcServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OwnerGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OwnerGrpcServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OwnerGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OwnerGrpcServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class OwnerGrpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getOwner(OwnerService.GetOwnerRequest request,
                         io.grpc.stub.StreamObserver<OwnerService.GetOwnerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOwnerMethod(), responseObserver);
    }

    /**
     */
    public void listOwners(OwnerService.GetAllOwnersRequest request,
                           io.grpc.stub.StreamObserver<OwnerService.GetAllOwnersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListOwnersMethod(), responseObserver);
    }

    /**
     */
    public void saveOwner(OwnerService.SaveOwnerRequest request,
                          io.grpc.stub.StreamObserver<OwnerService.SaveOwnerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveOwnerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOwnerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      OwnerService.GetOwnerRequest,
                      OwnerService.GetOwnerResponse>(
                  this, METHODID_GET_OWNER)))
          .addMethod(
            getListOwnersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      OwnerService.GetAllOwnersRequest,
                      OwnerService.GetAllOwnersResponse>(
                  this, METHODID_LIST_OWNERS)))
          .addMethod(
            getSaveOwnerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      OwnerService.SaveOwnerRequest,
                      OwnerService.SaveOwnerResponse>(
                  this, METHODID_SAVE_OWNER)))
          .build();
    }
  }

  /**
   */
  public static final class OwnerGrpcServiceStub extends io.grpc.stub.AbstractStub<OwnerGrpcServiceStub> {
    private OwnerGrpcServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OwnerGrpcServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OwnerGrpcServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OwnerGrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void getOwner(OwnerService.GetOwnerRequest request,
                         io.grpc.stub.StreamObserver<OwnerService.GetOwnerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOwnerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listOwners(OwnerService.GetAllOwnersRequest request,
                           io.grpc.stub.StreamObserver<OwnerService.GetAllOwnersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListOwnersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveOwner(OwnerService.SaveOwnerRequest request,
                          io.grpc.stub.StreamObserver<OwnerService.SaveOwnerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveOwnerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class OwnerGrpcServiceBlockingStub extends io.grpc.stub.AbstractStub<OwnerGrpcServiceBlockingStub> {
    private OwnerGrpcServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OwnerGrpcServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OwnerGrpcServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OwnerGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public OwnerService.GetOwnerResponse getOwner(OwnerService.GetOwnerRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOwnerMethod(), getCallOptions(), request);
    }

    /**
     */
    public OwnerService.GetAllOwnersResponse listOwners(OwnerService.GetAllOwnersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListOwnersMethod(), getCallOptions(), request);
    }

    /**
     */
    public OwnerService.SaveOwnerResponse saveOwner(OwnerService.SaveOwnerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaveOwnerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OwnerGrpcServiceFutureStub extends io.grpc.stub.AbstractStub<OwnerGrpcServiceFutureStub> {
    private OwnerGrpcServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OwnerGrpcServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OwnerGrpcServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OwnerGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<OwnerService.GetOwnerResponse> getOwner(
        OwnerService.GetOwnerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOwnerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<OwnerService.GetAllOwnersResponse> listOwners(
        OwnerService.GetAllOwnersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListOwnersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<OwnerService.SaveOwnerResponse> saveOwner(
        OwnerService.SaveOwnerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveOwnerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_OWNER = 0;
  private static final int METHODID_LIST_OWNERS = 1;
  private static final int METHODID_SAVE_OWNER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OwnerGrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OwnerGrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_OWNER:
          serviceImpl.getOwner((OwnerService.GetOwnerRequest) request,
              (io.grpc.stub.StreamObserver<OwnerService.GetOwnerResponse>) responseObserver);
          break;
        case METHODID_LIST_OWNERS:
          serviceImpl.listOwners((OwnerService.GetAllOwnersRequest) request,
              (io.grpc.stub.StreamObserver<OwnerService.GetAllOwnersResponse>) responseObserver);
          break;
        case METHODID_SAVE_OWNER:
          serviceImpl.saveOwner((OwnerService.SaveOwnerRequest) request,
              (io.grpc.stub.StreamObserver<OwnerService.SaveOwnerResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OwnerGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OwnerGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return OwnerService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OwnerGrpcService");
    }
  }

  private static final class OwnerGrpcServiceFileDescriptorSupplier
      extends OwnerGrpcServiceBaseDescriptorSupplier {
    OwnerGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class OwnerGrpcServiceMethodDescriptorSupplier
      extends OwnerGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OwnerGrpcServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OwnerGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OwnerGrpcServiceFileDescriptorSupplier())
              .addMethod(getGetOwnerMethod())
              .addMethod(getListOwnersMethod())
              .addMethod(getSaveOwnerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
