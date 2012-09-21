/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.jms;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Map;

/**
 * A <code>JMSProducer</code> is a simple object used to send messages on behalf
 * of a <code>JMSContext</code>. An instance of <code>JMSProducer</code> is
 * created by calling the <code>createProducer</code> method on a
 * <code>JMSContext</code>. It provides various <code>send</code> methods to
 * send a message to a specified destination. It also provides methods to allow
 * message send options, message properties and message headers to be specified
 * prior to sending a message or set of messages.
 * <p>
 * Message send options may be specified using one or more of the following
 * methods: <code>setDeliveryMode</code>, <code>setPriority</code>,
 * <code>setTimeToLive</code>, <code>setDeliveryDelay</code>,
 * <code>setDisableMessageTimestamp</code>, <code>setDisableMessageID</code> and
 * <code>setAsync</code>.
 * <p>
 * Message properties may be may be specified using one or more of nine
 * <code>setProperty</code> methods. Any message properties set using these
 * methods will override any message properties that have been set directly on
 * the message.
 * <p>
 * Message headers may be specified using one or more of the following methods:
 * <code>setJMSCorrelationID</code>, <code>setJMSCorrelationIDAsBytes</code>,
 * <code>setJMSType</code> or <code>setJMSReplyTo</code>. Any message headers
 * set using these methods will override any message headers that have been set
 * directly on the message.
 * <p>
 * All the above methods return the <code>JMSProducer</code> to allow method
 * calls to be chained together, allowing a fluid programming style. For
 * example:
 * <p>
 * <tt>context.createProducer().setDeliveryMode(DeliveryMode.NON_PERSISTENT).setTimeToLive(1000).send(destination, message);</tt>
 * <p>
 * Instances of <code>JMSProducer</code> are intended to be lightweight objects
 * which can be created freely and which do not consume significant resources.
 * This interface therefore does not provide a <code>close</code> method.
 * 
 * @version 2.0
 * @since 2.0
 * 
 */

public interface JMSProducer {

	/**
	 * Sends a message to the specified destination, using any send options,
	 * message properties and message headers that have been defined on this
	 * <code>JMSProducer</code>.
	 * 
	 * @param destination
	 *            the destination to send this message to
	 * @param message
	 *            the message to send
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to send the message due to some
	 *             internal error.
	 * @throws MessageFormatRuntimeException
	 *             if an invalid message is specified.
	 * @throws InvalidDestinationRuntimeException
	 *             if a client uses this method with an invalid destination.
	 * @throws MessageNotWriteableException
	 *             if this <code>JMSProducer</code> has been configured to set a
	 *             message property, but the message's properties are read-only
	 */
	JMSProducer send(Destination destination, Message message);

	/**
	 * Send a <code>TextMessage</code> with the specified payload to the
	 * specified destination, using any send options, message properties and
	 * message headers that have been defined on this <code>JMSProducer</code>.
	 * 
	 * @param destination
	 *            the destination to send this message to
	 * @param payload
	 *            the payload of the <code>TextMessage</code> that will be sent. 
	 *            If a null value is specified then a <code>TextMessage</code> 
	 *            with no payload will be sent.
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to send the message due to some
	 *             internal error.
	 * @throws MessageFormatRuntimeException
	 *             if an invalid message is specified.
	 * @throws InvalidDestinationRuntimeException
	 *             if a client uses this method with an invalid destination.
	 */
	JMSProducer send(Destination destination, String payload);

	/**
	 * Send a <code>MapMessage</code> with the specified payload to the
	 * specified destination, using any send options, message properties and
	 * message headers that have been defined on this <code>JMSProducer</code>.
	 * 
	 * @param destination
	 *            the destination to send this message to
	 * @param payload
	 *            the payload of the <code>MapMessage</code> that will be sent.
	 *            If a null value is specified then a <code>MapMessage</code> 
	 *            with no map entries will be sent.
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to send the message due to some
	 *             internal error.
	 * @throws MessageFormatRuntimeException
	 *             if an invalid message is specified.
	 * @throws InvalidDestinationRuntimeException
	 *             if a client uses this method with an invalid destination.
	 */
	JMSProducer send(Destination destination, Map<String, Object> payload);

	/**
	 * Send a <code>BytesMessage</code> with the specified payload to the
	 * specified destination, using any send options, message properties and
	 * message headers that have been defined on this <code>JMSProducer</code>.
	 * 
	 * @param destination
	 *            the destination to send this message to
	 * @param payload
	 *            the payload of the <code>BytesMessage</code> that will be
	 *            sent.
	 *            If a null value is specified then a <code>BytesMessage</code> 
	 *            with no payload will be sent.
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to send the message due to some
	 *             internal error.
	 * @throws MessageFormatRuntimeException
	 *             if an invalid message is specified.
	 * @throws InvalidDestinationRuntimeException
	 *             if a client uses this method with an invalid destination.
	 */
	JMSProducer send(Destination destination, byte[] payload);

	/**
	 * Send an <code>ObjectMessage</code> with the specified payload to the
	 * specified destination, using any send options, message properties and
	 * message headers that have been defined on this <code>JMSProducer</code>.
	 * 
	 * @param destination
	 *            the destination to send this message to
	 * @param payload
	 *            the payload of the ObjectMessage that will be sent.
	 *            If a null value is specified then an <code>ObjectMessage</code> 
	 *            with no payload will be sent.
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if JMS provider fails to send the message due to some
	 *             internal error.
	 * @throws MessageFormatRuntimeException
	 *             if an invalid message is specified.
	 * @throws InvalidDestinationRuntimeException
	 *             if a client uses this method with an invalid destination.
	 */
	JMSProducer send(Destination destination, Serializable payload);

	/**
	 * Specifies whether message IDs may be disabled for messages that are sent
	 * using this <code>JMSProducer</code>
	 * <p>
	 * Since message IDs take some effort to create and increase a message's
	 * size, some JMS providers may be able to optimise message overhead if they
	 * are given a hint that the message ID is not used by an application. By
	 * calling this method, a JMS application enables this potential
	 * optimisation for all messages sent using this <code>JMSProducer</code>.
	 * If the JMS provider accepts this hint, these messages must have the
	 * message ID set to null; if the provider ignores the hint, the message ID
	 * must be set to its normal unique value.
	 * <p>
	 * Message IDs are enabled by default.
	 * <p>
	 * 
	 * @param value
	 *            indicates whether message IDs may be disabled
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set message ID to disabled due
	 *             to some internal error.
	 * 
	 * @see javax.jms.JMSProducer#getDisableMessageID
	 */
	JMSProducer setDisableMessageID(boolean value);

	/**
	 * Gets an indication of whether message IDs are disabled.
	 * 
	 * @return an indication of whether message IDs are disabled
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to determine if message IDs are
	 *             disabled due to some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setDisableMessageID
	 */

	boolean getDisableMessageID();

	/**
	 * Specifies whether message timestamps may be disabled for messages that
	 * are sent using this <code>JMSProducer</code>. <pP> Since timestamps take
	 * some effort to create and increase a message's size, some JMS providers
	 * may be able to optimise message overhead if they are given a hint that
	 * the timestamp is not used by an application. By calling this method, a
	 * JMS application enables this potential optimisation for all messages sent
	 * using this <code>JMSProducer</code>. If the JMS provider accepts this
	 * hint, these messages must have the timestamp set to zero; if the provider
	 * ignores the hint, the timestamp must be set to its normal value.
	 * <p>
	 * Message timestamps are enabled by default.
	 * 
	 * @param value
	 *            indicates whether message timestamps may be disabled
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set timestamps to disabled due
	 *             to some internal error.
	 * 
	 * @see javax.jms.JMSProducer#getDisableMessageTimestamp
	 */
	JMSProducer setDisableMessageTimestamp(boolean value);

	/**
	 * Gets an indication of whether message timestamps are disabled.
	 * 
	 * @return an indication of whether message timestamps are disabled
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to determine if timestamps are
	 *             disabled due to some internal error.
	 * @see javax.jms.JMSProducer#setDisableMessageTimestamp
	 */
	boolean getDisableMessageTimestamp();

	/**
	 * Specifies the delivery mode of messages that are sent using this
	 * <code>JMSProducer</code>
	 * <p>
	 * Delivery mode is set to <code>PERSISTENT</code> by default.
	 * 
	 * @param deliveryMode
	 *            the message delivery mode to be used; legal values are
	 *            <code>DeliveryMode.NON_PERSISTENT</code> and
	 *            <code>DeliveryMode.PERSISTENT</code>
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the delivery mode due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#getDeliveryMode
	 * @see javax.jms.DeliveryMode#NON_PERSISTENT
	 * @see javax.jms.DeliveryMode#PERSISTENT
	 * @see javax.jms.Message#DEFAULT_DELIVERY_MODE
	 */
	JMSProducer setDeliveryMode(int deliveryMode);

	/**
	 * Returns the delivery mode of messages that are sent using this
	 * <code>JMSProducer</code>
	 * 
	 * @return the message delivery mode
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the delivery mode due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setDeliveryMode
	 */

	int getDeliveryMode();

	/**
	 * Specifies the priority of messages that are sent using this
	 * <code>JMSProducer</code>
	 * <p>
	 * The JMS API defines ten levels of priority value, with 0 as the lowest
	 * priority and 9 as the highest. Clients should consider priorities 0-4 as
	 * gradations of normal priority and priorities 5-9 as gradations of
	 * expedited priority. Priority is set to 4 by default.
	 * <p>
	 * 
	 * @param priority
	 *            the message priority to be used; must be a value between 0 and
	 *            9
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the priority due to some
	 *             internal error.
	 * 
	 * @see javax.jms.JMSProducer#getPriority
	 * @see javax.jms.Message#DEFAULT_PRIORITY
	 */

	JMSProducer setPriority(int priority);

	/**
	 * Return the priority of messages that are sent using this
	 * <code>JMSProducer</code>
	 * <p>
	 * 
	 * @return the message priority
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the priority due to some
	 *             internal error.
	 * 
	 * @see javax.jms.JMSProducer#setPriority
	 */

	int getPriority();

	/**
	 * Specifies the time to live of messages that are sent using this
	 * <code>JMSProducer</code>. This is used to determine the expiration time
	 * of a message.
	 * <p>
	 * The expiration time of a message is the sum of the message's time to live
	 * and the time it is sent. For transacted sends, this is the time the
	 * client sends the message, not the time the transaction is committed.
	 * <p>
	 * Clients should not receive messages that have expired; however, JMS does
	 * not guarantee that this will not happen.
	 * <p>
	 * A JMS provider should do its best to accurately expire messages; however,
	 * JMS does not define the accuracy provided. It is not acceptable to simply
	 * ignore time-to-live.
	 * <p>
	 * Time to live is set to zero by default, which means a message never
	 * expires.
	 * 
	 * @param timeToLive
	 *            the message time to live to be used, in milliseconds; a value
	 *            of zero means that a message never expires.
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the time to live due to some
	 *             internal error.
	 * 
	 * @see javax.jms.JMSProducer#getTimeToLive
	 * @see javax.jms.Message#DEFAULT_TIME_TO_LIVE
	 */
	JMSProducer setTimeToLive(long timeToLive);

	/**
	 * Returns the time to live of messages that are sent using this
	 * <code>JMSProducer</code>.
	 * 
	 * @return the message time to live in milliseconds; a value of zero means
	 *         that a message never expires.
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the time to live due to some
	 *             internal error.
	 * 
	 * @see javax.jms.JMSProducer#setTimeToLive
	 */

	long getTimeToLive();

	/**
	 * Sets the minimum length of time in milliseconds that must elapse after a
	 * message is sent before the JMS provider may deliver the message to a
	 * consumer.
	 * <p>
	 * For transacted sends, this time starts when the client sends the message,
	 * not when the transaction is committed.
	 * <p>
	 * deliveryDelay is set to zero by default.
	 * 
	 * @param deliveryDelay
	 *            the delivery delay in milliseconds.
	 * @return this <code>JMSProducer</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the delivery delay due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#getDeliveryDelay
	 * @see javax.jms.Message#DEFAULT_DELIVERY_DELAY
	 */

	JMSProducer setDeliveryDelay(long deliveryDelay);

	/**
	 * Gets the minimum length of time in milliseconds that must elapse after a
	 * message is sent before the JMS provider may deliver the message to a
	 * consumer.
	 * 
	 * @return the delivery delay in milliseconds.
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the delivery delay due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setDeliveryDelay
	 */
	long getDeliveryDelay();

	/**
	 * Specifies whether subsequent calls to <code>send</code> on this
	 * <code>JMSProducer</code> object should be synchronous or asynchronous. If
	 * the specified <code>CompletionListener</code> is not null then subsequent
	 * calls to <code>send</code> will be asynchronous. If the specified
	 * <code>CompletionListener</code> is null then subsequent calls to
	 * <code>send</code> will be synchronous. Calls to <code>send</code> are
	 * synchronous by default.
	 * <p>
	 * If a call to <code>send</code> is asynchronous then part of the work
	 * involved in sending the message will be performed in a separate thread
	 * and the specified <tt>CompletionListener</tt> will be notified when the
	 * operation has completed.
	 * <p>
	 * When the message has been successfully sent the JMS provider invokes the
	 * callback method <tt>onCompletion</tt> on the <tt>CompletionListener</tt>
	 * object. Only when that callback has been invoked can the application be
	 * sure that the message has been successfully sent with the same degree of
	 * confidence as if the send had been synchronous. An application which
	 * requires this degree of confidence must therefore wait for the callback
	 * to be invoked before continuing.
	 * <p>
	 * The following information is intended to give an indication of how an
	 * asynchronous send would typically be implemented.
	 * <p>
	 * In some JMS providers, a normal synchronous send involves sending the
	 * message to a remote JMS server and then waiting for an acknowledgement to
	 * be received before returning. It is expected that such a provider would
	 * implement an asynchronous send by sending the message to the remote JMS
	 * server and then returning without waiting for an acknowledgement. When
	 * the acknowledgement is received, the JMS provider would notify the
	 * application by invoking the <tt>onCompletion</tt> method on the
	 * application-specified <tt>CompletionListener</tt> object. If for some
	 * reason the acknowledgement is not received the JMS provider would notify
	 * the application by invoking the <tt>CompletionListener</tt>'s
	 * <tt>onException</tt> method.
	 * <p>
	 * In those cases where the JMS specification permits a lower level of
	 * reliability, a normal synchronous send might not wait for an
	 * acknowledgement. In that case it is expected that an asynchronous send
	 * would be similar to a synchronous send: the JMS provider would send the
	 * message to the remote JMS server and then return without waiting for an
	 * acknowledgement. However the JMS provider would still notify the
	 * application that the send had completed by invoking the
	 * <tt>onCompletion</tt> method on the application-specified
	 * <tt>CompletionListener</tt> object.
	 * <p>
	 * It is up to the JMS provider to decide exactly what is performed in the
	 * calling thread and what, if anything, is performed asynchronously, so
	 * long as it satisfies the requirements given below:
	 * <p>
	 * <b>Quality of service</b>: After the send operation has completed
	 * successfully, which means that the message has been successfully sent
	 * with the same degree of confidence as if a normal synchronous send had
	 * been performed, the JMS provider must invoke the
	 * <tt>CompletionListener</tt>'s <tt>onCompletion</tt> method. The
	 * <tt>CompletionListener</tt> must not be invoked earlier than this.
	 * <p>
	 * <b>Exceptions</b>: If an exception is encountered during the call to the
	 * <tt>send</tt> method then an appropriate exception should be thrown in
	 * the thread that is calling the <tt>send</tt> method. In this case the JMS
	 * provider must not invoke the <tt>CompletionListener</tt>'s
	 * <tt>onCompletion</tt> or <tt>onException</tt> method. If an exception is
	 * encountered which cannot be thrown in the thread that is calling the
	 * <tt>send</tt> method then the JMS provider must call the
	 * <tt>CompletionListener</tt>'s <tt>onException</tt> method. In both cases
	 * if an exception occurs it is undefined whether or not the message was
	 * successfully sent.
	 * <p>
	 * <b>Message order</b>: If the same <tt>JMSContext</tt> is used to send
	 * multiple messages then JMS message ordering requirements must be
	 * satisfied. This applies even if a combination of synchronous and
	 * asynchronous sends has been performed. The application is not required to
	 * wait for an asynchronous send to complete before sending the next
	 * message.
	 * <p>
	 * <b>Close, commit or rollback</b>: If the <tt>close</tt> method is called
	 * on the <tt>JMSContext</tt> then the JMS provider must block until any
	 * incomplete send operations have been completed and all
	 * <code>CompletionListener</code> callbacks have returned before closing
	 * the object and returning. If the session is transacted (uses a local
	 * transaction) then when the <tt>JMSContext</tt>'s <tt>commit</tt> or
	 * <tt>rollback</tt> method is called the JMS provider must block until any
	 * incomplete send operations have been completed and all
	 * <code>CompletionListener</code> callbacks have returned before performing
	 * the commit or rollback. Incomplete sends should be allowed to complete
	 * normally unless an error occurs.
	 * <p>
	 * A <tt>CompletionListener</tt> callback method must not call
	 * <tt>close</tt>, <tt>commit</tt> or <tt>rollback</tt> on its own
	 * <tt>JMSContext</tt>. Doing so will cause the <tt>close</tt>,
	 * <tt>commit</tt> or <tt>rollback</tt> to throw an
	 * <tt>IllegalStateRuntimeException</tt>.
	 * <p>
	 * <b>Restrictions on usage in Java EE</b> An asynchronous send is not
	 * permitted in a Java EE EJB or web container. If the application component
	 * violates this restriction this method may throw a JMSRuntimeException.
	 * <p>
	 * <b>Message headers</b> JMS defines a number of message header fields and
	 * message properties which must be set by the "JMS provider on send". If
	 * the send is asynchronous these fields and properties may be accessed on
	 * the sending client only after the <tt>CompletionListener</tt> has been
	 * invoked. If the <tt>CompletionListener</tt>'s <tt>onException</tt> method
	 * is called then the state of these message header fields and properties is
	 * undefined.
	 * <p>
	 * <b>Restrictions on threading</b>: Applications that perform an
	 * asynchronous send must confirm to the threading restrictions defined in
	 * JMS. This means that the session may be used by only one thread at a
	 * time.
	 * <p>
	 * Setting a <tt>CompletionListener</tt> does not cause the session to be
	 * dedicated to the thread of control which calls the
	 * <tt>CompletionListener</tt>. The application thread may therefore
	 * continue to use the session after performing an asynchronous send.
	 * However the <tt>CompletionListener</tt>'s callback methods must not use
	 * the session if an application thread might be using the session at the
	 * same time.
	 * <p>
	 * <b>Use of the <tt>CompletionListener</tt> by the JMS provider</b>: A
	 * session will only invoke one <tt>CompletionListener</tt> callback method
	 * at a time. For a given <tt>JMSContext</tt>, callbacks (both
	 * <code>onCompletion</code> and <code>onException</code>) will be performed
	 * in the same order as the corresponding calls to the <tt>send</tt> method.
	 * A JMS provider must not invoke the <tt>CompletionListener</tt> from the
	 * thread that is calling the <tt>send</tt> method.
	 * <p>
	 * <b>Restrictions on the use of the Message object</b>: Applications which
	 * perform an asynchronous send must take account of the restriction that a
	 * <tt>Message</tt> object is designed to be accessed by one logical thread
	 * of control at a time and does not support concurrent use.
	 * <p>
	 * After the <tt>send</tt> method has returned, the application must not
	 * attempt to read the headers, properties or payload of the
	 * <tt>Message</tt> object until the <tt>CompletionListener</tt>'s
	 * <tt>onCompletion</tt> or <tt>onException</tt> method has been called.
	 * This is because the JMS provider may be modifying the <tt>Message</tt>
	 * object in another thread during this time. The JMS provider may throw an
	 * <tt>JMSException</tt> if the application attempts to access or modify the
	 * <tt>Message</tt> object after the <tt>send</tt> method has returned and
	 * before the <tt>CompletionListener</tt> has been invoked. If the JMS
	 * provider does not throw an exception then the behaviour is undefined.
	 * 
	 * @param completionListener
	 *            If asynchronous send behaviour is required, this should be set
	 *            to a <code>CompletionListener</code> to be notified when the
	 *            send has completed. If synchronous send behaviour is required,
	 *            this should be set to <code>null</code>.
	 * @return this <code>JMSProducer</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if an internal error occurs
	 * 
	 * @see javax.jms.JMSProducer#getAsync
	 * @see javax.jms.CompletionListener
	 * 
	 */
	JMSProducer setAsync(CompletionListener completionListener);

	/**
	 * If subsequent calls to <code>send</code> on this
	 * <code>JMSProducer</code> object have been configured to be asynchronous 
	 * then this method returns the <code>CompletionListener</code>
	 * that has previously been configured.
	 * If subsequent calls to <code>send</code> have been configured to be synchronous
	 * then this method returns <code>null</code>.
	 * 
	 * @return the <code>CompletionListener</code> or <code>null</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the required information due
	 *             to some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setAsync
	 */
	CompletionListener getAsync();

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>boolean</code>
	 * value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>boolean</code> value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getBooleanProperty
	 */

	JMSProducer setProperty(String name, boolean value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>byte</code> value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>byte</code> value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getByteProperty
	 */
	JMSProducer setProperty(String name, byte value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>short</code>
	 * value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>short</code> property value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getShortProperty
	 */

	JMSProducer setProperty(String name, short value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>int</code> value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>int</code> property value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getIntProperty
	 */

	JMSProducer setProperty(String name, int value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>long</code> value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>long</code> property value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getLongProperty
	 */
	JMSProducer setProperty(String name, long value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>float</code>
	 * value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>float</code> property value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getFloatProperty
	 */
	JMSProducer setProperty(String name, float value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>double</code>
	 * value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>double</code> property value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getDoubleProperty
	 */
	JMSProducer setProperty(String name, double value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified <code>String</code>
	 * value.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the <code>String</code> property value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * 
	 * @see javax.jms.JMSProducer#getStringProperty
	 */
	JMSProducer setProperty(String name, String value);

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have the specified property set to the specified Java object value.
	 * <p>
	 * Note that this method works only for the objectified primitive object
	 * types (<code>Integer</code>, <code>Double</code>, <code>Long</code> ...)
	 * and <code>String</code> objects.
	 * <p>
	 * This will replace any property of the same name that is already set on
	 * the message being sent.
	 * 
	 * @param name
	 *            the name of the property
	 * @param value
	 *            the Java object property value to set
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the property due to some
	 *             internal error.
	 * @throws IllegalArgumentException
	 *             if the name is null or if the name is an empty string.
	 * @throws MessageFormatRuntimeException
	 *             if the object is invalid
	 * 
	 * @see javax.jms.JMSProducer#getObjectProperty
	 */
	JMSProducer setProperty(String name, Object value);

	/**
	 * Clears any message properties set on this <code>JMSProducer</code>
	 * 
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to clear the message properties due
	 *             to some internal error.
	 */
	JMSProducer clearProperties();

	/**
	 * Indicates whether a message property with the specified name has been set
	 * on this <code>JMSProducer</code>
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return true whether the property exists
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to determine whether the property
	 *             exists due to some internal error.
	 */
	boolean propertyExists(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>boolean</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>boolean</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,boolean)
	 */

	boolean getBooleanProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>String</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>byte</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,byte)
	 */

	byte getByteProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>short</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>short</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,short)
	 */
	short getShortProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>int</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>int</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,int)
	 */
	int getIntProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>long</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>long</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,long)
	 */
	long getLongProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>float</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>float</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,float)
	 */
	float getFloatProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>double</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>double</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,double)
	 */
	double getDoubleProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to a <code>String</code>.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the property value, converted to a <code>boolean</code>; if there
	 *         is no property by this name, a null value is returned
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * @throws MessageFormatRuntimeException
	 *             if this type conversion is invalid.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,String)
	 */
	String getStringProperty(String name);

	/**
	 * Returns the message property with the specified name that has been set on
	 * this <code>JMSProducer</code>, converted to objectified format.
	 * <p>
	 * This method can be used to return, in objectified format, an object that
	 * has been stored as a property in the message with the equivalent
	 * <code>setObjectProperty</code> method call, or its equivalent primitive
	 * <code>set<I>type</I>Property</code> method.
	 * 
	 * @param name
	 *            the name of the property
	 * 
	 * @return the Java object property value with the specified name, in
	 *         objectified format (for example, if the property was set as an
	 *         <code>int</code>, an <code>Integer</code> is returned); if there
	 *         is no property by this name, a null value is returned
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property value due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setProperty(java.lang.String,java.lang.Object)
	 */
	Object getObjectProperty(String name);

	/**
	 * Returns an <code>Enumeration</code> of the names of all the message
	 * properties that have been set on this <code>JMSProducer</code>.
	 * <p>
	 * Note that JMS standard header fields are not considered properties and
	 * are not returned in this enumeration.
	 * 
	 * @return an enumeration of all the names of property values
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the property names due to
	 *             some internal error.
	 */
	Enumeration getPropertyNames();

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have their <code>JMSCorrelationID</code> header value set to the
	 * specified correlation ID, where correlation ID is specified as an array
	 * of bytes.
	 * <p>
	 * This will override any <code>JMSCorrelationID</code> header value that is
	 * already set on the message being sent.
	 * <p>
	 * The array is copied before the method returns, so future modifications to
	 * the array will not alter the value in this <code>JMSProducer</code>.
	 * <p>
	 * If a provider supports the native concept of correlation ID, a JMS client
	 * may need to assign specific <code>JMSCorrelationID</code> values to match
	 * those expected by native messaging clients. JMS providers without native
	 * correlation ID values are not required to support this method and its
	 * corresponding get method; their implementation may throw a
	 * <code>java.lang.UnsupportedOperationException</code>.
	 * <p>
	 * The use of a <code>byte[]</code> value for <code>JMSCorrelationID</code>
	 * is non-portable.
	 * 
	 * @param correlationID
	 *            the correlation ID value as an array of bytes
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the correlation ID due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setJMSCorrelationID(String)
	 * @see javax.jms.JMSProducer#getJMSCorrelationID()
	 * @see javax.jms.JMSProducer#getJMSCorrelationIDAsBytes()
	 */
	JMSProducer setJMSCorrelationIDAsBytes(byte[] correlationID);

	/**
	 * Returns the <code>JMSCorrelationID</code> header value that has been set
	 * on this <code>JMSProducer</code>, as an array of bytes.
	 * <p>
	 * The use of a <code>byte[]</code> value for <code>JMSCorrelationID</code>
	 * is non-portable.
	 * 
	 * @return the correlation ID as an array of bytes
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the correlation ID due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setJMSCorrelationID(String)
	 * @see javax.jms.JMSProducer#getJMSCorrelationID()
	 * @see javax.jms.JMSProducer#setJMSCorrelationIDAsBytes(byte[])
	 */

	byte[] getJMSCorrelationIDAsBytes();

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have their <code>JMSCorrelationID</code> header value set to the
	 * specified correlation ID, where correlation ID is specified as a
	 * <code>String</code>.
	 * <p>
	 * This will override any <code>JMSCorrelationID</code> header value that is
	 * already set on the message being sent.
	 * <p>
	 * A client can use the <code>JMSCorrelationID</code> header field to link
	 * one message with another. A typical use is to link a response message
	 * with its request message.
	 * <p>
	 * <code>JMSCorrelationID</code> can hold one of the following:
	 * <UL>
	 * <LI>A provider-specific message ID
	 * <LI>An application-specific <code>String</code>
	 * <LI>A provider-native <code>byte[]</code> value
	 * </UL>
	 * <p>
	 * Since each message sent by a JMS provider is assigned a message ID value,
	 * it is convenient to link messages via message ID. All message ID values
	 * must start with the <code>'ID:'</code> prefix.
	 * <p>
	 * In some cases, an application (made up of several clients) needs to use
	 * an application-specific value for linking messages. For instance, an
	 * application may use <code>JMSCorrelationID</code> to hold a value
	 * referencing some external information. Application-specified values must
	 * not start with the <code>'ID:'</code> prefix; this is reserved for
	 * provider-generated message ID values.
	 * <p>
	 * If a provider supports the native concept of correlation ID, a JMS client
	 * may need to assign specific <code>JMSCorrelationID</code> values to match
	 * those expected by clients that do not use the JMS API. A
	 * <code>byte[]</code> value is used for this purpose. JMS providers without
	 * native correlation ID values are not required to support
	 * <code>byte[]</code> values. The use of a <code>byte[]</code> value for
	 * <code>JMSCorrelationID</code> is non-portable.
	 * 
	 * @param correlationID
	 *            the message ID of a message being referred to
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the correlation ID due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#getJMSCorrelationID()
	 * @see javax.jms.JMSProducer#getJMSCorrelationIDAsBytes()
	 * @see javax.jms.JMSProducer#setJMSCorrelationIDAsBytes(byte[])
	 */
	JMSProducer setJMSCorrelationID(String correlationID);

	/**
	 * Returns the <code>JMSCorrelationID</code> header value that has been set
	 * on this <code>JMSProducer</code>, as a <code>String</code>.
	 * <p>
	 * This method is used to return correlation ID values that are either
	 * provider-specific message IDs or application-specific <code>String</code>
	 * values.
	 * 
	 * @return the correlation ID of a message as a <code>String</code>
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the correlation ID due to
	 *             some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setJMSCorrelationID(String)
	 * @see javax.jms.JMSProducer#getJMSCorrelationIDAsBytes()
	 * @see javax.jms.JMSProducer#setJMSCorrelationIDAsBytes(byte[])
	 */
	String getJMSCorrelationID();

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have their <code>JMSType</code> header value set to the specified message
	 * type.
	 * <p>
	 * This will override any <code>JMSType</code> header value that is already
	 * set on the message being sent.
	 * <p>
	 * Some JMS providers use a message repository that contains the definitions
	 * of messages sent by applications. The <code>JMSType</code> header field
	 * may reference a message's definition in the provider's repository.
	 * <p>
	 * The JMS API does not define a standard message definition repository, nor
	 * does it define a naming policy for the definitions it contains.
	 * <p>
	 * Some messaging systems require that a message type definition for each
	 * application message be created and that each message specify its type. In
	 * order to work with such JMS providers, JMS clients should assign a value
	 * to <code>JMSType</code>, whether the application makes use of it or not.
	 * This ensures that the field is properly set for those providers that
	 * require it.
	 * <p>
	 * To ensure portability, JMS clients should use symbolic values for
	 * <code>JMSType</code> that can be configured at installation time to the
	 * values defined in the current provider's message repository. If string
	 * literals are used, they may not be valid type names for some JMS
	 * providers.
	 * 
	 * @param type
	 *            the message type
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the message type due to some
	 *             internal error.
	 * 
	 * @see javax.jms.JMSProducer#getJMSType()
	 */
	JMSProducer setJMSType(String type);

	/**
	 * Returns the <code>JMSType</code> header value that has been set on this
	 * <code>JMSProducer</code>.
	 * 
	 * @return the message type
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the message type due to some
	 *             internal error.
	 * 
	 * @see javax.jms.JMSProducer#setJMSType(String)
	 */
	String getJMSType();

	/**
	 * Specifies that messages sent using this <code>JMSProducer</code> will
	 * have their <code>JMSReplyTo</code> header value set to the specified
	 * <code>Destination</code> object.
	 * <p>
	 * This will override any <code>JMSReplyTo</code> header value that is
	 * already set on the message being sent.
	 * <p>
	 * The <code>JMSReplyTo</code> header field contains the destination where a
	 * reply to the current message should be sent. If it is null, no reply is
	 * expected. The destination may be either a <code>Queue</code> object or a
	 * <code>Topic</code> object.
	 * <p>
	 * Messages sent with a null <code>JMSReplyTo</code> value may be a
	 * notification of some event, or they may just be some data the sender
	 * thinks is of interest.
	 * <p>
	 * Messages with a <code>JMSReplyTo</code> value typically expect a
	 * response. A response is optional; it is up to the client to decide. These
	 * messages are called requests. A message sent in response to a request is
	 * called a reply.
	 * <p>
	 * In some cases a client may wish to match a request it sent earlier with a
	 * reply it has just received. The client can use the
	 * <code>JMSCorrelationID</code> header field for this purpose.
	 * 
	 * @param replyTo
	 *            <code>Destination</code> to which to send a response to this
	 *            message
	 * @return this <code>JMSProducer</code>
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to set the <code>JMSReplyTo</code>
	 *             destination due to some internal error.
	 * 
	 * @see javax.jms.JMSProducer#getJMSReplyTo()
	 */
	JMSProducer setJMSReplyTo(Destination replyTo);

	/**
	 * Returns the <code>JMSReplyTo</code> header value that has been set on
	 * this <code>JMSProducer</code>.
	 * <p>
	 * 
	 * @return <code>Destination</code> the <code>JMSReplyTo</code> header value
	 * 
	 * @throws JMSRuntimeException
	 *             if the JMS provider fails to get the <code>JMSReplyTo</code>
	 *             destination due to some internal error.
	 * 
	 * @see javax.jms.JMSProducer#setJMSReplyTo(Destination)
	 */
	Destination getJMSReplyTo();

}
