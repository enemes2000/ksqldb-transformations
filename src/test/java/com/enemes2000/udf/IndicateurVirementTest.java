package com.enemes2000.udf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndicateurVirementTest {

  IndicateurVirement indicateurVirement;

  @Before
  public void setUp(){
    indicateurVirement = new IndicateurVirement();
  }

  @Test
  public void getIndicateurDevirement_when_DSC_ORIG_TRX_HF13_is_null(){
    String DSC_ORIG_TRX_HF13 = null;
    assertEquals(indicateurVirement.getIndicateurDevirement(DSC_ORIG_TRX_HF13), 0);
  }

  @Test
  public void getIndicateurDevirement_when_DSC_ORIG_TRX_HF13_is_String_hex(){
    String DSC_ORIG_TRX_HF13 = "010203040ff";
    assertEquals(indicateurVirement.getIndicateurDevirement(DSC_ORIG_TRX_HF13), 1);
  }
}
