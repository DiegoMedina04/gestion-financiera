package com.example.micro2.application.casosUsos.cuenta;

import com.example.micro2.application.Dtos.ClienteDto;
import com.example.micro2.domian.exceptions.RegisterNotFound;
import com.example.micro2.domian.ports.in.cuenta.BuscarClienteCasoUso;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class BuscarClienteCasoUsoImpl implements BuscarClienteCasoUso {

    private final RestTemplate restTemplate;

    @Value("${microservicio1.url}")
    private String microservicio1Url;

    public BuscarClienteCasoUsoImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClienteDto buscarCliente(Long id ) {
           try {
               String url = microservicio1Url+"/cliente/"+ id;
               System.out.println("url: "+ url);
               HttpHeaders headers = new HttpHeaders();
               headers.set("Accept", "application/json");
               HttpEntity<String> entity = new HttpEntity<>(headers);

               ResponseEntity<ClienteDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, ClienteDto.class);

//               ResponseEntity<?> response = restTemplate.getForEntity(url, ClienteDto.class);
               HttpStatusCode codigoRespuestaEstado = response.getStatusCode();
               ClienteDto clienteDto = null;
               if(codigoRespuestaEstado == HttpStatus.OK) {
                   System.out.println("entro al if --- "+ response.getBody());
                   clienteDto = (ClienteDto) response.getBody();
               }
               return clienteDto;
           }catch (HttpClientErrorException e) {

               if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                   throw new RegisterNotFound("Cliente no encontrado");
               }
               System.out.printf("HttpClientErrorException "+ e.getMessage());
               throw e;
           } catch (Exception e) {
               throw new RuntimeException( e.getMessage());
           }
    }

}
