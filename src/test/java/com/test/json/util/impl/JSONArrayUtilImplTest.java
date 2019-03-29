package com.test.json.util.impl;

import com.test.json.util.JSONArrayUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JSONArrayUtilImplTest {

    JSONArrayUtil jsonArrayUtil;

    @Before
    public void setUp() throws Exception {
        jsonArrayUtil = new JSONArrayUtilImpl();
    }

    @After
    public void tearDown() throws Exception {
        jsonArrayUtil = null;
    }

    @Test
    public void sortPositive() throws JSONException {
        //given
        String[] stringArray = {"Five", "SiX", "TwO", "niNe"};
        JSONArray jsonArray = new JSONArray(stringArray);

        //when
        JSONArray sortedJsonArray = jsonArrayUtil.sort(jsonArray);

        //then
        assertThat(sortedJsonArray.getString(0), is("TwO"));

    }


    @Test(expected = IllegalArgumentException.class)
    public void sortNegative() throws JSONException {
        //given
        String[] stringArray = {};
        JSONArray jsonArray = new JSONArray(stringArray);

        //when
        jsonArrayUtil.sort(jsonArray);

        //then
        //expect IllegalArgumentException

    }
}