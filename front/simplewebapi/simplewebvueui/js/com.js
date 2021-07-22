var pager = {
		props: {
			pagerData: {
				type: Object,
				default: function() {
					return {
						data: [],
						rows: [],
						page: {
							//分页大小
							pagesize: 20,
							//分页数
							arrPageSize: [10, 20, 30, 40],
							//当前页面
							pageCurrent: 1,
							//总分页数
							pageCount: 1,
							//总数
							totalCount: 10
						}
					}
				}

			}
		},
		template: '<table class="table table-bordered table-responsive table-striped">\
                    <tr>\
                        <th v-for="item in pagerData.rows" v-on:click="sortBy(item.name)">{{item.label}}</th>\
                    </tr>\
                    <tr v-for="dataItem in pagerData.data | orderBy sortparam sorttype">\
                        <td v-for="item in pagerData.rows">{{dataItem[item.name]}}</td>\
                    </tr>\
                </table>\
                <div class="pager" id="pager">\
                    <span class="form-inline">\
                        <select class="form-control" v-model="pagesize" v-on:change="showPage(pageCurrent,$event)" number>\
                            <option v-for="item in pagerData.page.arrPageSize" value="{{item}}">{{item}}</option>\
                        </select>\
                    </span>\
                    <span class="btn btn-default" v-on:click="showPage(1,$event)">首页</span>\
                    <span class="btn btn-default" v-on:click="showPage(pageCurrent-1,$event)">上一页</span>\
                    <span class="form-inline">\
                    <input class="form-control" style="width:60px;text-align:center" type="text" v-model="pageCurrent" v-on:keyup.enter="showPage(mypageCurrent,$event,true)" />\
                    </span>\
                    <span>共{{pagerData.page.pageCount}}页</span>\
                    <span class="btn btn-default" v-on:click="showPage(pageCurrent+1,$event)">下一页</span>\
                    <span class="btn btn-default" v-on:click="showPage(pagerData.page.pageCount,$event)">尾页</span>\
                    <span>共{{pagerData.page.totalCount}}条数据，当前显示第{{startData}}-{{endData}}条记录</span>\
                </div>',
		data: function() {
			return {
				mypagesize: 10,
				mypageCurrent: 1,
				sortparam: "",
				sorttype: 1,
			}
		},
		//计算属性
		computed: {
			// 分页大小 获取的时候显示父级传入的，修改的时候修改自身的。子组件不能修改父元素的值
			pagesize: {
				get: function() {
					return this.pagerData.page.pagesize;
				},
				set: function(value) {
					this.mypagesize = value;
				}
			},
			pageCurrent: {
				get: function() {
					return this.pagerData.page.pageCurrent;
				},
				set: function(value) {
					this.mypageCurrent = value;
				}
			},
			startData: function() {
				return this.pagerData.page.pagesize * (this.pagerData.page.pageCurrent - 1) + 1;
			},
			endData: function() {
				var max = this.pagerData.page.pagesize * this.pagerData.page.pageCurrent;
				return max > this.pagerData.page.totalCount ? this.pagerData.page.totalCount : max;
			}
		},
		methods: {
			showPage: function(pageIndex, $event) {
				if (pageIndex > 0) {
					if (pageIndex > this.pagerData.page.pageCount) pageIndex = this.page.pageCount;
					this.$emit('show-page', {
						pageCurrent: pageIndex,
						pagesize: this.mypagesize
					}); //事件
				}
			},
			sortBy: function(sortparam) {
				this.sortparam = sortparam;
				this.sorttype = this.sorttype == -1 ? 1 : -1;
			}
		}
