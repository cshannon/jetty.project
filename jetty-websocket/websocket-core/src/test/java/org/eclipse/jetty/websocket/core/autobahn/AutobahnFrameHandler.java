//
// ========================================================================
// Copyright (c) 1995-2020 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under
// the terms of the Eclipse Public License 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0
//
// This Source Code may also be made available under the following
// Secondary Licenses when the conditions for such availability set
// forth in the Eclipse Public License, v. 2.0 are satisfied:
// the Apache License v2.0 which is available at
// https://www.apache.org/licenses/LICENSE-2.0
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

package org.eclipse.jetty.websocket.core.autobahn;

import java.nio.ByteBuffer;
import java.time.Duration;

import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.websocket.core.CoreSession;
import org.eclipse.jetty.websocket.core.TestMessageHandler;

public class AutobahnFrameHandler extends TestMessageHandler
{
    @Override
    public void onOpen(CoreSession coreSession, Callback callback)
    {
        coreSession.setIdleTimeout(Duration.ofSeconds(5));
        coreSession.setMaxTextMessageSize(Integer.MAX_VALUE);
        coreSession.setMaxBinaryMessageSize(Integer.MAX_VALUE);
        super.onOpen(coreSession, callback);
    }

    @Override
    public void onBinary(ByteBuffer wholeMessage, Callback callback)
    {
        sendBinary(wholeMessage, callback, false);
    }

    @Override
    public void onText(String wholeMessage, Callback callback)
    {
        sendText(wholeMessage, callback, false);
    }
}
