FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit systemd

SRC_URI += "file://nftables.service \
            file://nftables.rules \
            "
do_install_append() {

        install -d ${D}${sysconfdir}/nftables
        install -m 0644 ${WORKDIR}/nftables.rules ${D}${sysconfdir}/nftables

        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/nftables.service ${D}${systemd_system_unitdir}

	sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}${systemd_system_unitdir}/nftables.service
}

SYSTEMD_SERVICE_${PN} = "nftables.service"



