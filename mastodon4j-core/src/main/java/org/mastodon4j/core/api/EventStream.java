/*
 * SPDX-License-Identifier: MIT
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2023-2025 Mastodon4J
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.mastodon4j.core.api;

import org.mastodon4j.core.MastodonException;
import org.mastodon4j.core.api.entities.Event;
import org.mastodon4j.core.api.entities.Subscription;

import java.util.function.Consumer;

public interface EventStream extends AutoCloseable {
    /**
     * Adds a new event consumer to this stream.
     *
     * @param statusConsumer the event consumer to add
     */
    void registerConsumer(Consumer<Event> statusConsumer);

    /**
     * Sends the given subscription to that stream.
     *
     * @param subscription the subscription definition
     */
    void changeSubscription(Subscription subscription);

    /**
     * Closes the event stream and its underlying resources.
     *
     * @throws MastodonException if a error during the close operation occurs
     */
    @Override
    void close() throws MastodonException;
}
