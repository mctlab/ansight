package com.github.mctlab.ansight.common.delegate.context;

import com.github.mctlab.ansight.common.broadcast.BroadcastConfig;

public interface IDelegatable {

    public BroadcastConfig onCreateBroadcastConfig();
}
