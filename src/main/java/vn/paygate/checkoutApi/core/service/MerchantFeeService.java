package vn.paygate.checkoutApi.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.paygate.checkoutApi.core.repository.ConfigMerchantFeeRepository;
import vn.paygate.checkoutApi.core.entity.ConfigMerchantFee;


import java.util.List;

@Service
public class MerchantFeeService {
    @Autowired
    private ConfigMerchantFeeRepository configMerchantFeeRepository;

    public List<ConfigMerchantFee> getAllMerchantFee() {
        return configMerchantFeeRepository.findAll();
    }

    public ConfigMerchantFee save(ConfigMerchantFee configMerchantFee) {
        return configMerchantFeeRepository.save(configMerchantFee);
    }

    public List<ConfigMerchantFee> getMerchantFeesById(Long idFirst, Long idLast) {
        return configMerchantFeeRepository.findByIdFirstAndIdLast(idFirst, idLast);
    }
}
