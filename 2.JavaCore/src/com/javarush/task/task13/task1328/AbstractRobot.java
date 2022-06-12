package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable {
    private static int hitCount;

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        int b = 4;
        int a = 1;
        hitCount = a + (int) (Math.random() * b);

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            hitCount = 0;
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            hitCount = 0;
            attackedBodyPart = BodyPart.CHEST;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        int b = 4;
        int a = 1;
        hitCount = a + (int) (Math.random() * b);

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            hitCount = 0;
            defendedBodyPart = BodyPart.CHEST;
        } else if (hitCount == 4) {
            hitCount = 0;
            defendedBodyPart = BodyPart.ARM;
        }
        return defendedBodyPart;
    }
}
