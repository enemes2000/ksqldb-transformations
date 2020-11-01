package com.enemes2000.udf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VirementEntreCompteTest {

    VirementEntreCompte virementEntreCompte;

    @Before
    public void setUp(){
        virementEntreCompte = new VirementEntreCompte();
    }

    @Test
    public void extractVirementCompte_when_DSC_ORIG_TRX_HF13_equals_1(){
        final String DSC_ORIG_TRX_HF13 = "02F1815C30190C0052923CF0F2F0F1404040404040404040404040404040";

        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13).get("NUM-INSN-CNTP"),"8");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13).get("NUM-CAIS-CNTP"),"3");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13).get("NUM-FOLI-CNTP"),"0");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13).get("NUM-SERV-CNTP"),"F");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13).get("NUM-CMPT-CNTP"),"F");

    }
}
