package it.gov.pagopa.bpd.io_backend.builder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import javax.xml.bind.DatatypeConverter;
import java.time.Instant;
import java.util.Date;

public class TokenBuilder {

  private static TokenBuilder istance = null;

  private  TokenBuilder() {}

  public static TokenBuilder getIstance(){

      if(istance == null){
          istance = new TokenBuilder();
      }
      return istance;
  }

    public String buildToken(String fiscalCode) {

        String jws = Jwts.builder()
                .setSubject(fiscalCode)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(3600)))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(
                                "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
                )
                .compact();
        return  jws;
    }

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(
                        "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

}
