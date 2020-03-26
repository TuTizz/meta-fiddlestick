#!/bin/bash
RSTS="$(vcgencmd get_rsts)"
RSTS=${RSTS#*=}
RSTS=$(("0x$RSTS"))
STR="?"
# order is important as multiple bits can be set
if ((RSTS & 0x555)); then
    # reset (partition number of 62 (or ANY non-zero number) encoded in bits: 0,2,4,6,8,10)
    STR="NormalReset"
elif ((RSTS & 0x20)); then
    # dog trip
    STR="DogReset"
elif ((RSTS & 0x1000)); then
    # power cycle
    STR="PowerCycle"
fi
printf "RSTS=0x%08X CAUSE=%s\n" $RSTS $STR
