/*
 * Copyright 2012, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.blender;

import com.aoindustries.noc.monitor.common.SingleResultListener;
import com.aoindustries.noc.monitor.common.SingleResultNode;
import com.aoindustries.noc.monitor.common.SingleResult;
import java.rmi.RemoteException;

/**
 * @author  AO Industries, Inc.
 */
public class BlenderSingleResultNode extends BlenderNode implements SingleResultNode {

	final private SingleResultNode wrapped;

	protected BlenderSingleResultNode(BlenderMonitor monitor, SingleResultNode wrapped) {
		super(monitor, wrapped);
		this.wrapped = wrapped;
	}

	@Override
	public void addSingleResultListener(SingleResultListener singleResultListener) throws RemoteException {
		wrapped.addSingleResultListener(monitor.wrapSingleResultListener(singleResultListener));
	}

	@Override
	public void removeSingleResultListener(SingleResultListener singleResultListener) throws RemoteException {
		wrapped.removeSingleResultListener(monitor.wrapSingleResultListener(singleResultListener));
	}

	@Override
	public SingleResult getLastResult() throws RemoteException {
		return wrapped.getLastResult();
	}
}
