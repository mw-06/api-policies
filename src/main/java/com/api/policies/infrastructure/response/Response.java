package com.api.policies.infrastructure.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.util.List;

public class Response <T> {
//    private String message;
//    private HttpStatus status;
//    private String statusText;
//    private Integer statusCode;
    private T data;
    private Meta meta;

    public static class Meta {
        private String status;

        public Meta(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class Message {
        private String idMensaje;
        private String detalleMensaje;

        public Message(String idMensaje, String detalleMensaje) {
            this.idMensaje = idMensaje;
            this.detalleMensaje = detalleMensaje;
        }

        public String getIdMensaje() {
            return idMensaje;
        }

        public void setIdMensaje(String idMensaje) {
            this.idMensaje = idMensaje;
        }

        public String getDetalleMensaje() {
            return detalleMensaje;
        }

        public void setDetalleMensaje(String detalleMensaje) {
            this.detalleMensaje = detalleMensaje;
        }
    }

    public Response() {
    }

    public Response(Meta meta) {
        this.meta = meta;
    }

    public Response(Meta meta, T data) {
        this.meta = meta;
        this.data = data;
    }

//    public Response(HttpStatus status, String message, T data) {
//        this.status = status;
//        this.message = message;
//        this.data = data;
//    }

//    public static ResponseBody setStatus(HttpStatus status) {
//        return new ResponseBodyImpl(status);
//    }

    public static <T> Response<T> ok(T data) {
        Meta meta = new Meta("ok");
        return new Response<>(meta, data);
    }

    public static <T> Response<T> failure(String message, String detalleMensaje) {
        Meta meta = new Meta("failure");
        return new Response<>(meta, (T) new Message(message, detalleMensaje));
    }



    public interface ResponseBody {
        <T> Response<T> body(@Nullable T body);

        ResponseBody setMessage(String message);

    }

//    private static class ResponseBodyImpl implements ResponseBody {
//        private HttpStatus status;
//        private String message;
//        List<Object> body;
//        private final HttpHeaders headers = new HttpHeaders();
//
//        public ResponseBodyImpl() {
//            this.status = HttpStatus.OK;
//        }
//
//        public ResponseBodyImpl(HttpStatus status) {
//            this.status = status;
//        }
//
//        public ResponseBodyImpl(HttpStatus status, String message) {
//            this.status = status;
//            this.message = message;
//        }
//
//        public ResponseBodyImpl(HttpStatus status, String message, List<Object> body) {
//            this.status = status;
//            this.message = message;
//            this.body = body;
//        }
//
//        public ResponseBodyImpl(String message) {
//            this.message = message;
//        }
//
//        @Override
//        public <T> Response<T> body(@Nullable T body_) {
//            Response<T> response = new Response<>(status, message, body_);
//            return response;
//        }
//
//        @Override
//        public ResponseBody setMessage(String message) {
//            return new ResponseBodyImpl(status, message, body);
//        }
//
//        public ResponseBody header(String headerName, String... headerValues) {
//            String[] var3 = headerValues;
//            int var4 = headerValues.length;
//
//            for (int var5 = 0; var5 < var4; ++var5) {
//                String headerValue = var3[var5];
//                this.headers.add(headerName, headerValue);
//            }
//
//            return this;
//        }
//
//
//    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}