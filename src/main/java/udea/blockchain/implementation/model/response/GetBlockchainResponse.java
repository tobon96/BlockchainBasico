package udea.blockchain.implementation.model.response;

import lombok.Getter;
import lombok.Setter;
import udea.blockchain.implementation.model.model.Block;

import java.util.ArrayList;

@Getter
@Setter
public class GetBlockchainResponse {

    private ArrayList<Block> blockchain;

    public GetBlockchainResponse(ArrayList<Block> blockchain) {
        this.blockchain = blockchain;
    }
}
