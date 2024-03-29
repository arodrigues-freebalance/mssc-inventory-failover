package akr.microtraining.msscinventoryfailover.web;

import java.awt.List;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import akr.microtraining.msscinventoryfailover.model.BeerInventoryDto;
import reactor.core.publisher.Mono;

@Component
public class InventoryHandler {
    public Mono<ServerResponse> listInventory(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(Arrays.asList(
                	BeerInventoryDto.builder()
	                    .id(UUID.randomUUID())
	                    .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
	                    .quantityOnHand(999)
	                    .createdDate(OffsetDateTime.now())
	                    .lastModifiedDate(OffsetDateTime.now())
	                        .build())), List.class );
    }
}