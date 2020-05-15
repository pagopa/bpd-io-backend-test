package it.gov.pagopa.bpd.io_backend.service;

import io.jsonwebtoken.Claims;
import it.gov.pagopa.bpd.io_backend.builder.TokenBuilder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class FiscalCodeValidationServiceImpl implements FiscalCodeValidationService{


    @Override
    public @Valid String checkFiscalCode(String token) {
        List<String> testList = getFiscalCodeList();
        Claims claims = TokenBuilder.decodeJWT(token);
        String fiscalCode = claims.getSubject();
        for(String demoList : testList) {
            if(demoList.equals(fiscalCode)) {
                return fiscalCode;
            }
        }
        return null;
    }

    private List<String> getFiscalCodeList(){
        List<String> list = new ArrayList<>();
        list.add("DMGMQE73N12A023L");
        list.add("gfgettwqr54f65");
        list.add("ABDMUT63J21R324U");
        return list;
    }

}
