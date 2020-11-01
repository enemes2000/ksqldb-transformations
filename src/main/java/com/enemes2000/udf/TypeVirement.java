package com.enemes2000.udf;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "TypeVirement", description = "Type virement - Rule 4")
public class TypeVirement {

    @Udf(description = "Extract type de virement")
    public String extractTypeDeVirement(@UdfParameter("DSC_ORIG_TRX_HF13") String DSC_ORIG_TRX_HF13){
        if ( DSC_ORIG_TRX_HF13 != null && isAlphaAndNumeric(DSC_ORIG_TRX_HF13)) {

            return DSC_ORIG_TRX_HF13.substring(1,2);
        }
        return  null;
    }

    private boolean isAlphaAndNumeric(String str){
        return str != null && str.chars().allMatch(Character::isLetterOrDigit);
    }
}
