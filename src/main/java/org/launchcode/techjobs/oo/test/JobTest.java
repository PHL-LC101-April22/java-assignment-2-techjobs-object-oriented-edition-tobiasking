package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Assert;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job jobTest1;
    Job jobTest2;

    @Test
    public void testSettingJobId() {
        jobTest1 = new Job();
        jobTest2 = new Job();
        Assert.assertFalse(jobTest1.getId() == jobTest2.getId());
    }
}
