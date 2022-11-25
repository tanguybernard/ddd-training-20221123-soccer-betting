package com.zenika.soccerbetting.betting.domain.match;

import com.zenika.soccerbetting.shared_kernel.ValueObjectId;

public class MatchId extends ValueObjectId<String> {

    public MatchId(String id) {
        super(id);
    }
}
