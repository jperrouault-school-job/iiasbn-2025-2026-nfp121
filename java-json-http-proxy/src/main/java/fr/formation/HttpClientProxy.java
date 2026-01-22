package fr.formation;

import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

public class HttpClientProxy extends HttpClient {
    private HttpClient httpClient = HttpClient.newBuilder().build();
    private Map<String, HttpResponse<?>> cache = new HashMap<>();

    @Override
    public Optional<CookieHandler> cookieHandler() {
        return this.httpClient.cookieHandler();
    }

    @Override
    public Optional<Duration> connectTimeout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connectTimeout'");
    }

    @Override
    public Redirect followRedirects() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'followRedirects'");
    }

    @Override
    public Optional<ProxySelector> proxy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'proxy'");
    }

    @Override
    public SSLContext sslContext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sslContext'");
    }

    @Override
    public SSLParameters sslParameters() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sslParameters'");
    }

    @Override
    public Optional<Authenticator> authenticator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticator'");
    }

    @Override
    public Version version() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'version'");
    }

    @Override
    public Optional<Executor> executor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executor'");
    }

    @Override
    public <T> HttpResponse<T> send(HttpRequest request, BodyHandler<T> responseBodyHandler) throws IOException, InterruptedException {
        String uri = request.uri().toString();

        if (this.cache.containsKey(uri)) {
            System.out.println("Utilisation du cache ...");
            return (HttpResponse<T>)this.cache.get(uri);
        }

        System.out.println("Exécution de la requête ...");

        HttpResponse<T> response = this.httpClient.send(request, responseBodyHandler);

        this.cache.put(uri, response);

        return response;
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> responseBodyHandler) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendAsync'");
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> responseBodyHandler,
            PushPromiseHandler<T> pushPromiseHandler) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendAsync'");
    }

}
