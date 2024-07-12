import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

        private String urlApi;
        private int cantidad;
        private String pais1;
        private String pais2;

        public Conversor(String url_api, int cantidad, String pais1, String pais2){
            this.cantidad = cantidad;
            this.urlApi = url_api;
            this.pais1 = pais1;
            this.pais2 = pais2;
        }

        public String conversion() throws IOException, InterruptedException {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(getUrlApi() + getpais1() +
                            "/"+ getpais2() + "/" + String.valueOf(getcantidad())))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
           //System.out.println(response.body());
            Gson gson = new Gson();
            ConvertExchanges results = gson.fromJson(response.body(), ConvertExchanges.class);
            //System.out.println("result: "+ results);
            return getcantidad() + " " + getpais1() + " ==> " + results.conversion_result() + " " +
                    getpais2();
        }

        public String getUrlApi() {
            return urlApi;
        }

        public void setUrlApi(String url_api) {
            this.urlApi = url_api;
        }

        public int getcantidad() {
            return cantidad;
        }

        public void setcantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getpais1() {
            return pais1;
        }

        public void setpais1(String country1) {
            this.pais1 = country1;
        }

        public String getpais2() {
            return pais2;
        }

        public void setpais2(String country2) {
            this.pais2 = country2;
        }
}
