package com.enemes2000.udf;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "IndicateurVirement", description = "Indicateur de virement Rule 3")
public class IndicateurVirement {

    @Udf(description = "Obtenir un indicateur de virement")
    public int getIndicateurDevirement(@UdfParameter("DSC_ORIG_TRX_HF13") final String DSC_ORIG_TRX_HF13){
            return getIndicatorFrom(DSC_ORIG_TRX_HF13);
    }

    private int getIndicatorFrom(String hex) {
        if (hex == null) return 0;
        final String first_char = hex.trim().substring(0,2);
        switch (first_char){
            case "01" :
                return 1;
            case "02" :
                return 2;
            default:
                return 0;
        }
    }
}
