package it.gov.pagopa.bpd.io_backend.model.wallets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletNPInput {
    
    private String taxCode;
    private String pan;
    
}
