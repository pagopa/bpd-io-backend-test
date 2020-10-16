package it.gov.pagopa.bpd.io_backend.model.wallets.resource;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WalletsResource {

    public List<LEWallet> leWalletsCollection;
    public List<NPWallet> npWalletsCollection;

}
