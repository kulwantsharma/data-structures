package main.java;

public class Test {
    public static void main(String[] args) {

        String str = "SELECT new com.honeywell.CaaS.GatewayManagerAPI.webapi.web.model.software.CaasLicenseDTO" +
                "(csl.licenseKey,csl.metadata) from  CaasLicenseStatus cls right join cls.caasSoftwareLicense csl " +
                "where csl.licenseKey = ?1 and ((cls.status = 'Available' or cls.status is null) or (cls.siteId = ?2 and " +
                "cls.status = 'Assigned)";

        System.out.println(str);

    }
}
