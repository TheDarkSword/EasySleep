package it.mineblock.easysleep;

import it.mineblock.mbcore.Chat;

/**
 * Copyright © 2017 by Lorenzo Magni
 * All rights reserved. No part of this code may be reproduced, distributed, or transmitted in any form or by any means,
 * including photocopying, recording, or other electronic or mechanical methods, without the prior written permission
 * of the creator.
 */
public enum  Message {
    GOOD_MORNING("good-morning"),
    SLEEP_MISSING("sleep-missing"),
    LEAVE_MISSING("leave-missing"),
    SLEEP_SKIP("sleep-skip"),
    LEAVE_SKIP("leave-skip");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String get() {
        return Chat.getTranslated(Main.config.getString(this.msg));
    }

    public String getReplaced(String target, String replacement) {
        String message = Main.config.getString(this.msg);
        message = message.replace(target, replacement);
        return Chat.getTranslated(message);
    }

    public String getReplaced(String[] target, String[] replacement) {
        String msg = Main.config.getString("message." + this.msg);
        if(target.length != replacement.length) {
            return msg;
        }
        for(int i = 0; i < target.length; i++) {
            msg = msg.replace(target[i], replacement[i]);
        }
        return Chat.getTranslated(msg);
    }
}
