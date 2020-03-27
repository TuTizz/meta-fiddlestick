SUMMARY = "The fiddlestick image with some debug features on"

require image-fiddlestick.bb

IMAGE_FEATURES += "tools-debug debug-tweaks dev-pkgs"

CORE_IMAGE_EXTRA_INSTALL += "ethtool evtest fbset i2c-tools memtester"


