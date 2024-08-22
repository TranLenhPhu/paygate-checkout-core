package vn.paygate.checkoutApi.core.service;

import vn.paygate.checkoutApi.core.entity.ConfigMerchantFee;
import vn.paygate.checkoutApi.core.entity.ConfigPaymentMethodChannel;
import vn.paygate.checkoutApi.core.entity.Merchant;
import vn.paygate.checkoutApi.core.model.input.MerchantInput;
import vn.paygate.checkoutApi.core.model.output.MerchantOutput;
import vn.paygate.checkoutApi.core.repository.ConfigMerchantFeeRepository;
import vn.paygate.checkoutApi.core.repository.ConfigPaymentMethodChannelRepository;
import vn.paygate.checkoutApi.core.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private ConfigMerchantFeeRepository configMerchantFeeRepository;

    @Autowired
    private ConfigPaymentMethodChannelRepository configPaymentMethodChannelRepository;

    public Merchant convertMerchantInputToMerchant(MerchantInput input){
        Merchant merchant = findMerchantByUserId(input.getUserId());
        merchant.setPhone(input.getPhone());
        merchant.setAddress(input.getAddress());
        merchant.setMerchantName(input.getMerchantName());
        merchant.setMerchantTags(input.getMerchantTags());
        merchant.setMerchantType(input.getMerchantType());
        merchant.setCheckoutDisplayName(input.getCheckoutDisplayName());
        merchant.setCheckoutDisplayPhone(input.getCheckoutDisplayPhone());
        merchant.setCheckoutDisplayAddress(input.getCheckoutDisplayAddress());
        merchant.setCheckoutDisplayLogoUrl(input.getCheckoutDisplayLogoUrl());
        merchant.setIntegrationNotifyUrl(input.getIntegrationNotifyUrl());
        return merchant;
    }

    private MerchantOutput convertMerchantToMerchantOutput(Merchant merchant){
        MerchantOutput merchantOutput = new MerchantOutput();

        merchantOutput.setId(merchant.getId());
        merchantOutput.setUserId(merchant.getUserId());
        merchantOutput.setMerchantName(merchant.getMerchantName());
        merchantOutput.setCheckoutDisplayName(merchant.getCheckoutDisplayName());
        merchantOutput.setAddress(merchant.getAddress());
        merchantOutput.setCheckoutDisplayAddress(merchant.getCheckoutDisplayAddress());
        merchantOutput.setPhone(merchant.getPhone());
        merchantOutput.setCheckoutDisplayPhone(merchant.getCheckoutDisplayPhone());
        merchantOutput.setCheckoutDisplayLogoUrl(merchant.getCheckoutDisplayLogoUrl());
        merchantOutput.setMerchantType(merchant.getMerchantType());
        merchantOutput.setMerchantTags(merchant.getMerchantTags());
        merchantOutput.setIntegrationMerchantCode(merchant.getIntegrationMerchantCode());
        merchantOutput.setIntegrationNotifyUrl(merchant.getIntegrationNotifyUrl());
        merchantOutput.setIntegrationSecurePassMassedPan(merchant.getIntegrationSecurePassMassedPan());

        return merchantOutput;
    }

    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    public Merchant findMerchantByUserId(String userId){
        return merchantRepository.findMerchantByUserId(userId);
    }

    public List<Merchant> getAllMerchants(){
        return merchantRepository.findAll();
    }

    public List<MerchantOutput> getMerchantsById(Long idFirst, Long idLast){
        List<Merchant> Merchants = merchantRepository.findByIdFirstAndIdLast(idFirst, idLast);
        return Merchants.stream()
                .map(this::convertMerchantToMerchantOutput)
                .collect(Collectors.toList());
    }

    public List<ConfigPaymentMethodChannel> getFilteredConfigPaymentMethodChannelsByMerchantId(String merchantId) {
        List<ConfigMerchantFee> configMerchantFees = configMerchantFeeRepository.findByMerchantId(merchantId);
        List<String> allowedPaymentMethodCodes = configMerchantFees.stream()
                .map(ConfigMerchantFee::getPayment_method_code)
                .collect(Collectors.toList());
        return configPaymentMethodChannelRepository.findByMerchantId(merchantId).stream()
                .filter(channel -> allowedPaymentMethodCodes.contains(channel.getPayment_method_code()))
                .collect(Collectors.toList());
    }

    public Merchant findMerchantByIntegrationSecureCode(String integrationMerchantCode) {
        return merchantRepository.findByIntegrationMerchantCode(integrationMerchantCode);
    }
}
