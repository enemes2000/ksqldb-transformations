package com.enemes2000.udf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionInterCaisseTest {

    TransactionInterCaisse transactionInterCaisse;

    @Before
    public void setUp(){
        transactionInterCaisse = new TransactionInterCaisse();

    }

    @Test
    public void extractTransactionInterCaisse_when_IND_INTR_CAIS_equals_1_and_DSC_ORIG_TRX_HF13_not_null(){
        final String IND_INTR_CAIS = "TRUE";
        final String DSC_ORIG_TRX_HF13 = "";
        assertEquals(transactionInterCaisse.extractIndicateurInterCaisse(IND_INTR_CAIS, DSC_ORIG_TRX_HF13), "I");
    }

    @Test
    public void extractTransactionInterCaisse_when_IND_INTR_CAIS_equals_1_and_DSC_ORIG_TRX_HF13_is_null(){
        final String IND_INTR_CAIS = "TRUE";
        final String DSC_ORIG_TRX_HF13 = null;
        assertEquals(transactionInterCaisse.extractIndicateurInterCaisse(IND_INTR_CAIS, DSC_ORIG_TRX_HF13), "O");
    }

    @Test
    public void extractTransactionInterCaisse_when_IND_INTR_CAIS_equals_0(){
        final String IND_INTR_CAIS = "FALSE";
        final String DSC_ORIG_TRX_HF13 = null;
        assertEquals(transactionInterCaisse.extractIndicateurInterCaisse(IND_INTR_CAIS, DSC_ORIG_TRX_HF13), "");
    }
}
