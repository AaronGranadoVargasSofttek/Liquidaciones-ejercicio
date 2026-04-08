package helloworld.liquidaciondiversos.lossRegistration;

import helloworld.liquidaciondiversos.Risk;
import helloworld.liquidaciondiversos.realValueCalculator.realValueCalculatorImpl;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;

public class lossRegistrationImpl implements lossRegistration
{
    LocalDate date;
    String contactName;
    String location;
    String policyID;
    List<Good> goods;
    Risk cause;

    HashMap<Good,Integer> realValues;

    public lossRegistrationImpl(LocalDate date, String contactName, String location, Policy policy, Risk cause)
    {
        this.date = date;
        this.location = location;
        this.cause = cause;
        this.contactName = policy.getClient().getName();
        this.policyID = policy.getPolicyID();
        this.goods = policy.getGoods();
        calculateRealValues(this.goods);
    }

    public HashMap<Good, Integer> getRealValues()
    {
        return this.realValues;
    }

    @Override
    public void calculateRealValues(List<Good> goods)
    {
        for (Good good : goods)
        {
            realValues.put(good, realValueCalculatorImpl.calc(good.getPurchaseValue(), good.getAntiquity()));
        }
    }
}
