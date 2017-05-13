/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.core.controller;

import com.badlogic.gdx.controllers.ControllerListener;

/**
 * Common interface for mini2Dx controller implementations
 */
public interface MdxController<T extends MdxControllerListener> extends ControllerListener {

	/**
	 * Returns the {@link ControllerType} for this controller
	 * @return {@link ControllerType#UNKNOWN} if the controller is unknown
	 */
	public ControllerType getControllerType();
	
	/**
	 * Inserts a listener at the specified index to the controller
	 * @param index The index to insert the listener at
	 * @param listener The listener to insert
	 */
	public void addListener(int index, T listener);
	
	/**
	 * Adds a listener to the controller
	 * @param listener The listener to add
	 */
	public void addListener(T listener);
	
	/**
	 * Removes a listener at the specified index from this controller
	 * @param index The index to remove
	 */
	public void removeListener(int index);
	
	/**
	 * Removes a listener from this controller
	 * @param listener The listener to remove
	 */
	public void removeListener(T listener);
	
	/**
	 * Gets the listener at the specified index for this controller
	 * @param index The index to return
	 * @return The listener
	 */
	public T getListener(int index);
	
	/**
	 * Returns the total number of listeners for this controller
	 * @return 0 if there are no listeners
	 */
	public int getTotalListeners();
	
	/**
	 * Removes all listeners from this controller
	 */
	public void clearListeners();
}
