package com.enemes2000.udf;


import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "TypeOperation", description = "Verification du type d'operation - Regle 2")
public class TypeOperation {
    @Udf(description = "Get the type of operation")
    public String getTypeOperation(@UdfParameter("TYP_OPRN_DRD_HF13") final String TYP_OPRN_DRD_HF13 ,
                                   @UdfParameter("COD_KJCO_TRX_HF13") final String COD_KJCO_TRX_HF13 ){

        if (isAlphaAndNumeric(TYP_OPRN_DRD_HF13)) return "T".concat(TYP_OPRN_DRD_HF13);
        else if (isAlphaAndNumeric(COD_KJCO_TRX_HF13))
            return COD_KJCO_TRX_HF13.substring(0,3).concat("C");
        return null;
    }

    private boolean isAlphaAndNumeric(String str){
        return str != null && str.chars().allMatch(Character::isLetterOrDigit);
    }
}
