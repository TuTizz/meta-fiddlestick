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

pkg_postinst_ontarget_${PN}() {


for dev in /sys/class/net/*;
do
	if [ ! -e $dev/device/uevent ]; then
		continue;
	fi 
#	grep  "PRODUCT=424/ec00/200"  $dev/device/uevent
#	if [ "$?" =  "0" ]; then
#		echo "MACAddress=$(cat $dev/address)" >> ${sysconfdir}/systemd/network/br0.netdev
#	fi 
#	grep  "PRODUCT=2001/1a02/200"  $dev/device/uevent
#	if [ "$?" =  "0" ]; then
#                echo "MACAddress=$(cat $dev/address)" >> ${sysconfdir}/systemd/network/br0.netdev
#    fi
    grep  "DRIVER=lan78xx"  $dev/device/uevent
	if [ "$?" =  "0" ]; then
                echo "MACAddress=$(cat $dev/address)" >> ${sysconfdir}/systemd/network/br0.netdev
    fi
done
}

