package com.api.policies.modules.policy.infrastructure.adapters.in.rest;

import com.api.policies.infrastructure.response.Response;
import com.api.policies.modules.core.domain.models.Log;
import com.api.policies.modules.core.domain.services.LogService;
import com.api.policies.modules.policy.domain.models.Policy;
import com.api.policies.modules.policy.domain.ports.in.PolicyRest;
import com.api.policies.modules.policy.domain.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("policies")
public class PolicyController implements PolicyRest {
    @Autowired
    private PolicyService policyService;
    @Autowired
    private LogService logService;

    @Override
    @GetMapping("")
    public Response getPolicies() {
        try {
            List<Policy> policies = policyService.getPolicies();
            return Response.ok(policies);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("getPolicies - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al obtener los registros.", e.getMessage());
        }
    }

    @Override
    @GetMapping("/{idPolicy}")
    public Response getPolicyById(@PathVariable Integer idPolicy) {
        try {
            Policy policy = policyService.getPolicyById(idPolicy);
            return Response.ok(policy);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("getPolicyById - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al obtener los registros.", e.getMessage());
        }
    }

    @Override
    @PostMapping()
    public Response savePolicy(@RequestBody Policy policy) {
        try {
            Policy policySaved = policyService.savePolicy(policy);
            return Response.ok(policySaved);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("savePolicy - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al guardar la póliza.", e.getMessage());
        }
    }

    @Override
    @PutMapping("/delete/{idPolicy}")
    public Response deletePolicy(@PathVariable Integer idPolicy) {
        try {
            Policy policy = policyService.deletePolicy(idPolicy);
            return Response.ok(policy);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("deletePolicy - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrio un error al eliminar el registro.", e.getMessage());
        }
    }
}
