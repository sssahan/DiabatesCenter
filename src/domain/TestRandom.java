/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author sachithra sahan
 */
public class TestRandom extends Report{
    private String result;

    /**
     * @return the result
     */
    @Override
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    @Override
    public void setResult(String result) {
        this.result = result;
    }
}
