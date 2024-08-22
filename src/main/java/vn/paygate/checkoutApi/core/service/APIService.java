package vn.paygate.checkoutApi.core.service;

import org.apache.commons.lang3.RandomStringUtils;
import vn.paygate.checkoutApi.core.entity.*;
import vn.paygate.checkoutApi.core.global_variable.*;
import vn.paygate.checkoutApi.core.model.input.MerchantInput;
import vn.paygate.checkoutApi.core.model.output.CheckoutDepositOutput;
import vn.paygate.checkoutApi.core.model.output.CheckoutTransferOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.paygate.checkoutApi.core.model.output.MerchantOutput;
import vn.paygate.checkoutApi.core.repository.ConfigMerchantFeeRepository;
import vn.paygate.lib.encryption.MerchantEncryption;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class APIService {

    @Autowired
    private MerchantService merchantService;
    @Autowired
    private MerchantFeeService configMerchantFeeService;

    public String newMerchant(MerchantInput input) throws Exception {
        MerchantEncryption merchantEncryption = new MerchantEncryption();
        Merchant merchant = new Merchant();

        Merchant existingMerchant = merchantService.findMerchantByUserId(input.getUserId());
        if (existingMerchant != null) {
            return ErrorCode.MERCHANT_ALREADY_EXISTED;
        }

        String randomStr = RandomStringUtils.randomAlphanumeric(16);
        String secureCode = merchantEncryption.encrypt(randomStr);
        String firstPart = randomStr.substring(0, 4);
        String lastPart = randomStr.substring(randomStr.length() - 4);
        String massedPanPass = firstPart + "****" + lastPart;

        merchant.setAddress(input.getAddress());
        merchant.setPhone(input.getPhone());
        merchant.setCheckoutDisplayAddress(input.getCheckoutDisplayAddress());
        merchant.setCheckoutDisplayName(input.getCheckoutDisplayName());
        merchant.setCheckoutDisplayLogoUrl(input.getCheckoutDisplayLogoUrl());
        merchant.setCheckoutDisplayPhone(input.getCheckoutDisplayPhone());
        merchant.setMerchantName(input.getMerchantName());
        merchant.setMerchantTags(input.getMerchantTags());
        merchant.setMerchantType(input.getMerchantType());
        merchant.setUserId(input.getUserId());
        merchant.setIntegrationSecureCode(secureCode);
        merchant.setIntegrationSecurePassMassedPan(massedPanPass);
        merchant.setIntegrationNotifyUrl(input.getIntegrationNotifyUrl());
        merchantService.save(merchant);

        return randomStr;
    }

    public List<MerchantOutput> getMerchant(Long idFirst, Long idLast) {
        return merchantService.getMerchantsById(idFirst, idLast);
    }

    public Merchant saveMerchant(MerchantInput input) {
        return merchantService.save(merchantService.convertMerchantInputToMerchant(input));
    }

    public Merchant newTestMerchant() {
        Merchant merchant = new Merchant();
        merchant.setUserId("103");
        return merchantService.save(merchant);
    }

    public ConfigMerchantFee saveMerchantFee(ConfigMerchantFee input) {
        return configMerchantFeeService.save(input);
    }

    public List<ConfigMerchantFee> getMerchantFees(Long idFirst, Long idLast) {
        return configMerchantFeeService.getMerchantFeesById(idFirst, idLast);
    }
}
