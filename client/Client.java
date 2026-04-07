package helloworld.liquidaciondiversos.client;

import helloworld.liquidaciondiversos.policy.Policy;
import lombok.Data;

@Data
public class Client {
    private String name;
    private String address;
    private String phoneNumber;
    private String Nif;
    private Policy policy;
}
