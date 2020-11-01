package com.enemes2000.udf;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "TransactionInterCaisse", description = "Transaction inter caisse - Rule 6")
public class TransactionInterCaisse {

    @Udf(description = "extraire Indicateur Inter caisse")
    public String extractIndicateurInterCaisse(@UdfParameter("IND_INTR_CAIS") final String IND_INTR_CAIS,
                                           @UdfParameter("DSC_ORIG_TRX_HF13") final String DSC_ORIG_TRX_HF13){
        if (isAlphaAndNumeric(IND_INTR_CAIS) && "TRUE".equalsIgnoreCase(IND_INTR_CAIS)){
            if (isAlphaAndNumeric(DSC_ORIG_TRX_HF13) ) return "I";
            else return "O";
        }else return "";
    }

    private boolean isAlphaAndNumeric(String str){
        return str != null && str.chars().allMatch(Character::isLetterOrDigit);
    }

}
