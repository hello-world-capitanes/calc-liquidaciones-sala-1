package com.liquidaciondiversos.example;

import com.liquidaciondiversos.model.Sinister;
import com.liquidaciondiversos.model.*;
import com.liquidaciondiversos.model.enums.PaymentType;
import com.liquidaciondiversos.model.enums.WarrantyType;
import lombok.Data;

import java.util.*;

@Data
public class BaseData {
    private Map<String, Product> products;
    private Map<String, Risk> risks;

    private Map<String, Warranty> warranties;

    private Map<Integer, Client> clients;

    private Map<Integer, Policy> policies;

    private Map<String, Sinister> sinisters;

    public BaseData(){

        createRisks();
        createWarranties();
        createClients();
        createProducts();
        createPolicies();
        //createSinisters();

    }

    private void createClients(){
        this.clients = new HashMap<Integer, Client>();
        Client client1 = new Client();
        client1.setId(1);
        client1.setName("Carlos");
        client1.setSurname("Gómez");
        client1.setDirection("Passeig de Gràcia, 175, Barcelona");
        client1.setTelephone("632975473");
        client1.setNif("52873237X");
        client1.setWarranty(this.warranties.get("RO"));
        this.clients.put(client1.getId(), client1);

        Client client2 = new Client();

        client2.setId(2);
        client2.setName("Laura");
        client2.setSurname("Jiménez");
        client2.setDirection("Gran Via, 99, Madrid");
        client2.setTelephone("721654123");
        client2.setNif("41009243D");
        client2.setWarranty(this.warranties.get("HA"));
        this.clients.put(client2.getId(), client2);

    }

    private void createRisks(){
        this.risks = new HashMap<String, Risk>();
        Risk riskRoberyOutside = new Risk();
        riskRoberyOutside.setCode("RO");
        riskRoberyOutside.setName("Robery outside");
        Risk riskWind = new Risk();
        riskWind.setCode("WI");
        riskWind.setName("Wind Over 50Kmh");
        Risk riskMoisture = new Risk();
        riskWind.setCode("MS");
        riskWind.setName("Moisture");

        this.risks.put(riskWind.getCode(), riskWind);

    }
    /**
    private void createSinisters(){
        this.sinisters = new HashMap<String, Sinister>();
        Date fechaActual = new Date();
        Sinister sinister1 = new Sinister();
        sinister1.setCode("RO");
        sinister1.setPolicy(this.policies.get(2));
        sinister1.setDate(fechaActual);
        sinister1.setCause("Robery Outside");
        sinister1.setDamagedList(createProductWarranties());

        this.sinisters.put(sinister1.getCode(), sinister1);


    }*/

    private void createWarranties(){
        this.warranties = new HashMap<String, Warranty>();
        Warranty warrantyRoberyOutside = new Warranty();
        warrantyRoberyOutside.setCode("RO");
        warrantyRoberyOutside.setName("Robery outside");
        warrantyRoberyOutside.setWarrantyType(WarrantyType.CONTENT);

        Warranty warrantyRoof = new Warranty();
        warrantyRoof.setCode("RF");
        warrantyRoof.setName("Roof");
        warrantyRoof.setWarrantyType(WarrantyType.BUILDING);

        Warranty warrantyGeneralBuilding = new Warranty();
        warrantyGeneralBuilding.setCode("GB");
        warrantyGeneralBuilding.setName("General Building");
        warrantyGeneralBuilding.setWarrantyType(WarrantyType.BUILDING);

        Warranty warrantyHomeAppliances = new Warranty();
        warrantyHomeAppliances.setCode("HA");
        warrantyHomeAppliances.setName("Home Appliances");
        warrantyHomeAppliances.setWarrantyType(WarrantyType.CONTENT);

        this.warranties.put(warrantyRoberyOutside.getCode(), warrantyRoberyOutside);
        this.warranties.put(warrantyRoof.getCode(), warrantyRoof);
        this.warranties.put(warrantyGeneralBuilding.getCode(), warrantyGeneralBuilding);
        this.warranties.put(warrantyHomeAppliances.getCode(), warrantyHomeAppliances);
    }

    private void createProducts(){
        this.products = new HashMap<String, Product>();
        Product product = new Product();
        product.setCode("HOGAR15");
        product.setName("AXA Hogar 15");

        product.setProductWarranties(this.createProductWarranties());

        this.products.put(product.getCode(), product);
    }

    private void createPolicies(){
        this.policies = new HashMap<Integer, Policy>();
        Policy policy = new Policy();
        policy.setId(1);
        policy.setProduct(this.products.get("HOGAR15"));
        policy.setClient(this.clients.get(2));
        this.policies.put(policy.getId(), policy);

        Policy policy2 = new Policy();
        policy2.setId(2);
        policy2.setProduct(this.products.get("HOGAR15"));
        policy2.setClient(this.clients.get(1));
        this.policies.put(policy2.getId(), policy2);


    }

    private List<ProductWarranty> createProductWarranties(){
        List<ProductWarranty> warranties = new ArrayList<ProductWarranty>();

        ProductWarranty warrantyRoberyOutside = new ProductWarranty();
        warrantyRoberyOutside.setExcluded(false);
        warrantyRoberyOutside.setCapitalInsured(300.0);
        warrantyRoberyOutside.setRisk(this.risks.get("RO"));
        warrantyRoberyOutside.setPaymentType(PaymentType.PRIMER_RIESGO);
        warrantyRoberyOutside.setWarranty(this.warranties.get("RO"));


        ProductWarranty warrantyRoberyOutsideRoof = new ProductWarranty();
        warrantyRoberyOutsideRoof.setExcluded(true);
        warrantyRoberyOutsideRoof.setRisk(this.risks.get("RO"));
        warrantyRoberyOutsideRoof.setWarranty(this.warranties.get("RF"));
        ProductWarranty warrantyRoberyGeneralBuilding = new ProductWarranty();
        warrantyRoberyGeneralBuilding.setExcluded(true);
        warrantyRoberyGeneralBuilding.setRisk(this.risks.get("RO"));
        warrantyRoberyGeneralBuilding.setWarranty(this.warranties.get("GB"));
        ProductWarranty warrantyRoberyOutsideHomeAppliance = new ProductWarranty();
        warrantyRoberyOutsideHomeAppliance.setExcluded(true);
        warrantyRoberyOutsideHomeAppliance.setRisk(this.risks.get("RO"));
        warrantyRoberyOutsideHomeAppliance.setWarranty(this.warranties.get("HA"));

        warranties.add(warrantyRoberyOutside);
        warranties.add(warrantyRoberyOutsideRoof);
        warranties.add(warrantyRoberyGeneralBuilding);
        warranties.add(warrantyRoberyOutsideHomeAppliance);

        ProductWarranty warrantyWindRoof = new ProductWarranty();
        warrantyWindRoof.setExcluded(false);
        warrantyWindRoof.setCapitalInsured(1300);
        warrantyWindRoof.setRisk(this.risks.get("WI"));
        warrantyWindRoof.setPaymentType(PaymentType.REPOSICION_NUEVO);
        warrantyWindRoof.setWarranty(this.warranties.get("RF"));
        ProductWarranty warrantyWindRoberyOutside = new ProductWarranty();
        warrantyWindRoberyOutside.setExcluded(true);
        warrantyWindRoberyOutside.setRisk(this.risks.get("WI"));
        warrantyWindRoberyOutside.setWarranty(this.warranties.get("RO"));
        ProductWarranty warrantyWindGeneralBuilding = new ProductWarranty();
        warrantyWindGeneralBuilding.setExcluded(true);
        warrantyWindGeneralBuilding.setRisk(this.risks.get("WI"));
        warrantyWindGeneralBuilding.setWarranty(this.warranties.get("GB"));
        ProductWarranty warrantyWindHomeAppliance = new ProductWarranty();
        warrantyWindHomeAppliance.setExcluded(true);
        warrantyWindHomeAppliance.setRisk(this.risks.get("WI"));
        warrantyWindHomeAppliance.setWarranty(this.warranties.get("HA"));

        warranties.add(warrantyWindRoof);
        warranties.add(warrantyWindRoberyOutside);
        warranties.add(warrantyWindGeneralBuilding);
        warranties.add(warrantyWindHomeAppliance);

        ProductWarranty warrantyMoistureRoof = new ProductWarranty();
        warrantyMoistureRoof.setExcluded(false);
        warrantyMoistureRoof.setRisk(this.risks.get("MS"));
        warrantyMoistureRoof.setWarranty(this.warranties.get("RF"));

        ProductWarranty warrantyMoistureRoberyOutside = new ProductWarranty();
        warrantyMoistureRoberyOutside.setExcluded(true);
        warrantyMoistureRoberyOutside.setRisk(this.risks.get("MS"));
        warrantyMoistureRoberyOutside.setWarranty(this.warranties.get("RO"));
        ProductWarranty warrantyMoistureGeneralBuilding = new ProductWarranty();
        warrantyRoberyOutsideRoof.setExcluded(false);
        warrantyRoberyOutsideRoof.setCapitalInsured(20000);
        warrantyRoberyOutsideRoof.setRisk(this.risks.get("MS"));
        warrantyRoberyOutsideRoof.setWarranty(this.warranties.get("GB"));
        ProductWarranty warrantyMoistureHomeAppliance = new ProductWarranty();
        warrantyMoistureHomeAppliance.setExcluded(false);
        warrantyMoistureHomeAppliance.setCapitalInsured(3000);
        warrantyMoistureHomeAppliance.setRisk(this.risks.get("MS"));
        warrantyMoistureHomeAppliance.setWarranty(this.warranties.get("HA"));

        warranties.add(warrantyMoistureRoof);
        warranties.add(warrantyMoistureRoberyOutside);
        warranties.add(warrantyMoistureGeneralBuilding);
        warranties.add(warrantyMoistureHomeAppliance);

        return warranties;

    }


}
