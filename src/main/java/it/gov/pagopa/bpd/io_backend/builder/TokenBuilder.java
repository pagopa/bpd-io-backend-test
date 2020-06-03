package it.gov.pagopa.bpd.io_backend.builder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.time.Instant;
import java.util.Date;

@Component
public class TokenBuilder {

  private static TokenBuilder istance = null;

  private  TokenBuilder() {}

  public static TokenBuilder getIstance(){

      if(istance == null){
          istance = new TokenBuilder();
      }
      return istance;
  }

    public String buildToken(String fiscalCode, String key) {

        String jws = Jwts.builder()
                .setSubject(fiscalCode)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(3600)))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(key)
                )
                .compact();
        return  jws;
    }

    public static Claims decodeJWT(String jwt, String key) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

}
