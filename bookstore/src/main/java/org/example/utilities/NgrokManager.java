package org.example.utilities;

import com.github.alexdlaird.ngrok.NgrokClient;
import com.github.alexdlaird.ngrok.conf.JavaNgrokConfig;
import com.github.alexdlaird.ngrok.protocol.CreateTunnel;
import com.github.alexdlaird.ngrok.protocol.Region;
import com.github.alexdlaird.ngrok.protocol.Tunnel;
import org.hibernate.cfg.Environment;
import org.springframework.stereotype.Component;

@Component
public class NgrokManager {
     private String url;
     private static String authToken = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUpATunnel()
    {
        if (url == null) {
            JavaNgrokConfig javaNgrokConfig = new JavaNgrokConfig.Builder()
                    .withAuthToken(authToken)
                    .withRegion(Region.valueOf("EU"))
                    .build();

            NgrokClient ngrokClient = new NgrokClient.Builder()
                    .withJavaNgrokConfig(javaNgrokConfig)
                    .build();

            CreateTunnel createTunnel = new CreateTunnel.Builder()
                    .withAddr("8080")
                    .build();

            Tunnel tunnel = ngrokClient.connect(createTunnel);
            this.url = tunnel.getPublicUrl();
        }
    }

}