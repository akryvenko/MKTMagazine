package com.mariya;

import org.apache.struts.util.MessageResources;
import org.apache.struts.util.MessageResourcesFactory;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 29.05.2010
 * Time: 13:21:19
 * To change this template use File | Settings | File Templates.
 */
public class MKTMessageResourceFactory extends MessageResourcesFactory {

    public MessageResources createResources(String config) {
        return new MKTMessageResources(this, config, this.returnNull);
    }
}


