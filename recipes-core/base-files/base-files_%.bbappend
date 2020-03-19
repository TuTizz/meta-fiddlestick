FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://80-eth_ext.link \
            file://81-eth_int.link \
            file://82-eth_ext.link \
            file://br0.netdev \
            file://lan-bridge.network \
            "

do_install_append() {
    # Add custom systemd conf network files
    install -d ${D}${sysconfdir}/systemd/network

    # Add custom systemd conf network files
    install -m 0644 ${WORKDIR}/*.network ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/*.link ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/*.netdev ${D}${sysconfdir}/systemd/network/
}


