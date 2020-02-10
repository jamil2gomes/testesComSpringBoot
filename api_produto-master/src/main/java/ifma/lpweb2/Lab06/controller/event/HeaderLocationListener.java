package ifma.lpweb2.Lab06.controller.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class HeaderLocationListener implements ApplicationListener<HeaderLocationEvent> {


    @Override
    public void onApplicationEvent(HeaderLocationEvent event) {
        adicionaHeaderLocationNaRespostaHTTP(event);

    }

    private void adicionaHeaderLocationNaRespostaHTTP(HeaderLocationEvent event) {
        HttpServletResponse response = event.getResponse();
        Integer id = event.getId();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        response.setHeader("Location", uri.toString() );
    }
}