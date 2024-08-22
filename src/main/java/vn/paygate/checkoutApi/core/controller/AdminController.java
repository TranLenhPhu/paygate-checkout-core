package vn.paygate.checkoutApi.core.controller;

import vn.paygate.checkoutApi.core.entity.*;
import vn.paygate.checkoutApi.core.model.input.*;
import vn.paygate.checkoutApi.core.model.output.*;
import vn.paygate.checkoutApi.core.service.APIService;
import vn.paygate.checkoutApi.core.service.MerchantService;
import vn.paygate.checkoutApi.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private APIService apiService;

    @PostMapping("/newtestmerchant")
    public ResponseEntity<Merchant> newTestMerchant() throws Exception {
        return ResponseEntity.ok(apiService.newTestMerchant());
    }

    @PostMapping("/newmerchant")
    public ResponseEntity<String> newMerchant(@RequestBody @Valid MerchantInput input) throws Exception {
        return ResponseEntity.ok(apiService.newMerchant(input));
    }

    @GetMapping("/getmerchant/{idFirst}/{idLast}")
    public ResponseEntity<List<MerchantOutput>> getMerchant(@PathVariable Long idFirst, @PathVariable Long idLast) {
        return ResponseEntity.ok(apiService.getMerchant(idFirst, idLast));
    }

    @PostMapping("/savemerchant")
    public ResponseEntity<Merchant> saveMerchant(@RequestBody @Valid MerchantInput input) {
        return ResponseEntity.ok(apiService.saveMerchant(input));
    }

    @PostMapping("/newmerchantfee")
    public ResponseEntity<ConfigMerchantFee> newMerchantFee(@RequestBody @Valid ConfigMerchantFee input) throws Exception {
        return ResponseEntity.ok(apiService.saveMerchantFee(input));
    }

    @GetMapping("/getmerchantfee/{idFirst}/{idLast}")
    public ResponseEntity<List<ConfigMerchantFee>> getMerchantFee(@PathVariable Long idFirst, @PathVariable Long idLast) {
        return ResponseEntity.ok(apiService.getMerchantFees(idFirst, idLast));
    }

    @PostMapping("/savemerchantfee")
    public ResponseEntity<ConfigMerchantFee> saveMerchantFee(@RequestBody @Valid ConfigMerchantFee input) {
        return ResponseEntity.ok(apiService.saveMerchantFee(input));
    }
}
