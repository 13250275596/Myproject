package com.example.myproject.service.tax;

import org.springframework.stereotype.Service;

@Service
public class TaxService{
    
    /**
     * 增值税
     * @param money
     * @return
     */
    public double valueAddedTax(double money){
        double result = money/(1+0.03)*0.03;
        return result;
    }

    /**
     * 城建税
     * 应缴增值税*5%
     * 月/季
     * @param money
     * @return
     */
    public double buildingTax(double money){
        double addTax = valueAddedTax(money);
        double result = addTax*0.05;
        return result;
    }

    /**
     * 教育费附加
     * 应缴增值税*3%
     * 月/季
     * @param money
     * @return
     */
    public double educationSurcharge(double money){
        double addTax = valueAddedTax(money);
        double result = addTax*0.03;
        return result;
    }

    /**
     * 地方教育费附加
     * 应缴增值税*2%
     * 月/季
     * @param money
     * @return
     */
    public double localEducationSurcharge(double money){
        double addTax = valueAddedTax(money);
        double result = addTax*0.02;
        return result;
    }

    /**
     * 印花税
     * 合同金额*0.05% 房屋预售备案 中的销售金额，但计税时间为取得不动产登记证台账 
     * 月/季
     * @param money
     * @return  
     */
    public double stampDuty(double money){
        double result = money*0.05*0.01;
        return result;
    }

    /**
     * 土地增值税
     * 销售额*预征率 房屋预售备案
     * 年
     * @param money
     * @return
     */
    public double landValueAddedTax(double money,double percent){
        double result = money*percent;
        return result;
    }

    /**
     * 房产税（自用）
     * 房产原值*70%*1.2% 净入库获取
     * 4、10月
     * @param money
     * @return
     */
    public double propertyTaxSelf(double money){
        double result = money*0.70*1.2*0.01;
        return result;
    }

    /**
     * 房产税（出租）
     * 租金*12% 净入库获取
     * 4、10月
     * @param money
     * @return
     */
    public double propertyTaxRent(double money){
        double result = money*0.12;
        return result;
    }

    /**
     * 土地使用税
     * 占地面积*适用税额 净入库获取
     * 4、10月
     * 适用税额按路段划分，分别为2.4.6.8元
     * @param money
     * @return
     */
    public double landHoldingTax(double square,double perSquare){
        double result = square*perSquare;
        return result;
    }

    /**
     * 企业所得税
     * （营业额-实际抵扣税额）*25%
     * 月/季   年
     * @param money
     * @return
     */
    public double corporateIncomeTax(double money,double deduction){
        double result = (money-deduction)*0.25;
        return result;
    }

}
