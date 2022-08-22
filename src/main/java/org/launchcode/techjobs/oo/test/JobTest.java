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
    @Test
    public void testJobConstructorSetsAllFields() {
        Job test = new Job("Rocketship", new Employer("LaunchCode"), new Location("In Orbit"), new PositionType("Astronomical"), new CoreCompetency("Fuel Burn-Off"));
        Assert.assertTrue(test.getName() instanceof String);
        Assert.assertTrue(test.getEmployer() instanceof Employer);
        Assert.assertTrue(test.getLocation() instanceof Location);
        Assert.assertTrue(test.getPositionType() instanceof PositionType);
        Assert.assertTrue(test.getCoreCompetency() instanceof CoreCompetency);

        Assert.assertEquals("Rocketship", test.getName());
        Assert.assertEquals("LaunchCode", test.getEmployer().getValue());
        Assert.assertEquals("In Orbit", test.getLocation().getValue());
        Assert.assertEquals("Astronomical", test.getPositionType().getValue());
        Assert.assertEquals("Fuel Burn-Off", test.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Rocketship", new Employer("LaunchCode"), new Location("In Orbit"), new PositionType("Astronomical"), new CoreCompetency("Fuel Burn-Off"));
        Job jobTwo = new Job("Mars Rover", new Employer("NASA"), new Location("Mars"), new PositionType("On Surface"), new CoreCompetency("Pain"));
        Assert.assertFalse(jobOne.equals(jobTwo));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobOne = new Job("Rocketship", new Employer("LaunchCode"), new Location("In Orbit"), new PositionType("Astronomical"), new CoreCompetency("Fuel Burn-Off"));
        String expectResult = "ID: 5\nName: Rocketship\nEmployer: LaunchCode\nLocation: In Orbit\nPosition Type: Astronomical\nCore Competency: Fuel Burn-Off";
        char first = jobOne.toString().charAt(0);
        char last = jobOne.toString().charAt(jobOne.toString().length()-1);
        Assert.assertEquals('\n' + expectResult + '\n', jobOne.toString());
        Assert.assertEquals(first, '\n');
        Assert.assertEquals(last, '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobOne = new Job("Rocketship", new Employer("LaunchCode"), new Location("In Orbit"), new PositionType("Astronomical"), new CoreCompetency("Fuel Burn-Off"));
        String expectresult = "\nID: 4\nName: Rocketship\nEmployer: LaunchCode\nLocation: In Orbit\nPosition Type: Astronomical\nCore Competency: Fuel Burn-Off\n";
        Assert.assertEquals(expectresult, jobOne.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job jobOne = new Job("Rocketship", new Employer("LaunchCode"), new Location("In Orbit"), new PositionType(""), new CoreCompetency(""));
        String expectresult = "\nID: 3\nName: Rocketship\nEmployer: LaunchCode\nLocation: In Orbit\nPosition Type: Data not available\nCore Competency: Data not available\n";
        Assert.assertEquals(expectresult, jobOne.toString());
    }
}
