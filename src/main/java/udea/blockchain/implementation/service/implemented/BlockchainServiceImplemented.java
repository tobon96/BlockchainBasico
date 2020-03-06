package udea.blockchain.implementation.service.implemented;

import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.Blockchain;
import udea.blockchain.implementation.model.response.GetBlockchainResponse;
import udea.blockchain.implementation.service.BlockchainService;

@Service
public class BlockchainServiceImplemented implements BlockchainService {

    @Override
    public GetBlockchainResponse getBlockchain() {
        return new GetBlockchainResponse(Blockchain.getInstance().getBlockchain());
    }
}
